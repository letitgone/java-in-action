package design.pattern.singleton;

/**
 * 单例模式--懒汉模式
 * 问题：getInstance()方法线程不安全
 *
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class Lazy {

    private static Lazy lazy = null;

    private Lazy() {

    }

    public static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
