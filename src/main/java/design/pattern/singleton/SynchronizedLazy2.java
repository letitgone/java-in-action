package design.pattern.singleton;

/**
 * 单例模式--懒汉模式（线程安全）
 * 双重检查锁定
 * 这种写法是错误的
 * 由于指令重排优化，可能会导致初始化单例对象和将该对象地址赋值给synchronizedLazy2字段的顺序与代码顺序不同。
 *
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class SynchronizedLazy2 {

    private static SynchronizedLazy2 synchronizedLazy2 = null;

    private SynchronizedLazy2() {

    }

    public static SynchronizedLazy2 getInstance() {
        if (synchronizedLazy2 == null) {
            synchronized (SynchronizedLazy2.class) {
                if (synchronizedLazy2 == null) {
                    synchronizedLazy2 = new SynchronizedLazy2();
                }
            }
        }
        return synchronizedLazy2;
    }
}
