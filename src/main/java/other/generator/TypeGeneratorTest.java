package other.generator;

import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/10/15
 */
public class TypeGeneratorTest {
    public static void main(String[] args) {
        Map<String , String> map = TypeGenerator.getInstance().map;
        System.out.println(map);
    }
}
