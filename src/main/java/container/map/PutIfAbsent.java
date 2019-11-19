package container.map;

import java.util.HashMap;

/**
 * @Author ZhangGJ
 * @Date 2019/11/19
 */
public class PutIfAbsent {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Object obj = hashMap.putIfAbsent("A", null);
        if (obj == null) {
            System.out.println("Shit : NPE!");
        }
        hashMap.putIfAbsent("A", 16);
        hashMap.putIfAbsent("A", 17);
        hashMap.putIfAbsent("B", 100);
        hashMap.putIfAbsent("B", 150);
        Integer i = (Integer) hashMap.putIfAbsent("B", 200);
        hashMap.put("C", 222);
        hashMap.put("C", 23);
        System.out.println(hashMap);
        System.out.println(i);
    }
}
