package design.pattern.builder.variant;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class VariantBuilderTest {
    public static void main(String[] args) {
        Person person = new Person
            .Builder("张三", "男")
            .age("12")
            .money("1000000")
            .car("宝马")
            .build();
    }
}
