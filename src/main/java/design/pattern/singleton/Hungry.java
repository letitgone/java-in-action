package design.pattern.singleton;

/**
 * 单例模式--饿汉模式
 *
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class Hungry {

    private static final Hungry hungry = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return hungry;
    }
}
