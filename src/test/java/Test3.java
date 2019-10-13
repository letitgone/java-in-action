import design.pattern.singleton.SynchronizedLazy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/10/12
 */
public class Test3 {
    public void test(){
        SynchronizedLazy synchronizedLazy = SynchronizedLazy.getInstance();
        Map<String, String> map = synchronizedLazy.map;
        System.out.println(map);
    }
    public static void main(String[] args) {
        Test3 test = new Test3();
        test.test();
        System.out.println(new Date());
        System.out.println(new Date().toString());
    }
}
