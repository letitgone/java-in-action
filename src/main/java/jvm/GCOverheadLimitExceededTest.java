package jvm;

import java.util.Map;
import java.util.Random;

/**
 * @Author ZhangGJ
 * @Date 2021/07/15 15:12
 */
public class GCOverheadLimitExceededTest {

    /**
     * -Xms20m -Xmx20m
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<Object, Object> map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
            System.out.println("test");
        }
    }
}
