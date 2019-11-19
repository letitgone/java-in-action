package container.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/11/19
 */
public class GetOrDefault {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "lxj");
        map.put("age", "24");
        map.put("sex", "女");
        String name = map.getOrDefault("name", "test");
        System.out.println(name);// lxj，map中存在name,获得name对应的value
        String address = map.getOrDefault("address", "北京");
        System.out.println(address);// 北京，map中不存在address,使用默认值“北京”
    }
}
