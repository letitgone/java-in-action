package date;

import java.util.*;

/**
 * list<Map> 进行时间排序
 */
public class DateSort {
    public static void main(String[] args) {
        List<Map> list = new ArrayList<>();
        Date s = new Date();
        Date s1 = new DateSort().yesterday(new Date());
        Date s2 = new DateSort().tomorrow(new Date());
        Map<String, Date> map = new HashMap();
        map.put("time", s);
        map.put("s", null);
        Map<String, Date> map2 = new HashMap();
        map2.put("time", s2);
        map2.put("s2", null);
        Map<String, Date> map3 = new HashMap();
        map3.put("time", s1);
        map3.put("s1", null);
        list.add(map);
        list.add(map2);
        list.add(map3);
        System.out.println(list);
        Collections.sort(list, Comparator.comparing((Map o) -> o.get("time").toString()));
        System.out.println(list);
    }

    /**
     * 返回昨天
     * @param today
     * @return
     */
    public Date yesterday(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        return calendar.getTime();
    }

    /**
     * 返回明天
     * @param today
     * @return
     */
    public Date tomorrow(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.getTime();
    }
}