package design.pattern.singleton;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 单例模式--饿汉模式
 */
public class Hungry {

    // 创建唯一实例
    private static final Hungry hungry = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return hungry;
    }
}
