package thread;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/12/18 15:20
 */
@Repository
public interface UserMapper {
    /**
     * 查询所有用户与主组织机构信息
     *
     * @param currentUserType
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<Map<String, Object>> selectUserInfoMainGroup1(@Param("currentUserType") Integer currentUserType, @Param("fromIndex") Integer fromIndex, @Param("toIndex") Integer toIndex);

}
