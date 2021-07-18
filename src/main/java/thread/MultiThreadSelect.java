package thread;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author ZhangGJ
 * @Date 2021/07/19 07:20
 */
public class MultiThreadSelect {

    @Autowired
    private UserMapper userMapper;

    public Map<String, List<Map<String, Object>>> selectUserInfoMainGroup1(Integer entryStatus) {
        Integer currentUserType = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<List<Map<String, Object>>>> futureList = new LinkedList<>();
        List<Map<String, Object>> userList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Future<List<Map<String, Object>>> future = executorService
                    .submit(new CallableUserList(userMapper, currentUserType,
                            "ContextHandler.getDatabase()", i));
            futureList.add(future);
        }
        try {
            for (Future<List<Map<String, Object>>> future : futureList) {
                userList.addAll(future.get());
            }
        } catch (Exception e) {
            executorService.shutdownNow();
            e.printStackTrace();
            return null;
        }
        Map<String, List<Map<String, Object>>> resign =
                userList.stream().collect(groupingBy(map -> map.get("resign").toString()));
        if (!"1".equals(entryStatus)) {
            resign.remove("离职");
        }
        return resign;
    }

    static class CallableUserList implements Callable<List<Map<String, Object>>> {

        private final UserMapper userMapper;

        private final Integer currentUserType;

        private final String schema;

        private final int currentNum;

        private CallableUserList(UserMapper userMapper, Integer currentUserType, String schema, int currentNum) {
            this.userMapper = userMapper;
            this.currentUserType = currentUserType;
            this.schema = schema;
            this.currentNum = currentNum;
        }

        @Override
        public List<Map<String, Object>> call() {
            return selectUser(currentNum);
        }

        public List<Map<String, Object>> selectUser(int currentNum) {
//            ContextHandler.setDatabase(schema);
            int[] pagination = pagination(59701, 10, currentNum);
            return userMapper.selectUserInfoMainGroup1(currentUserType, pagination[0], pagination[1]);
        }

    }

    /**
     * 分页计算
     *
     * @param total
     * @param threadNum
     * @param currentNum
     * @return
     */
    private static int[] pagination(int total, int threadNum, int currentNum) {
        if (currentNum > threadNum) {
            return new int[] {};
        }
        double d = total / (double) threadNum;
        int ceil = (int) Math.ceil(d);
        if (currentNum == 1) {
            return new int[] {0, ceil};
        } else if (currentNum == threadNum) {
            return new int[] {(currentNum - 1) * ceil, ceil - (ceil * threadNum - total)};
        } else {
            return new int[] {(currentNum - 1) * ceil, ceil};
        }
    }
}
