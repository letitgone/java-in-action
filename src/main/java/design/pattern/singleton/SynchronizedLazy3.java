package design.pattern.singleton;

/**
 * 单例模式--懒汉模式（线程安全）
 * 双重检查锁定
 * 增加volatile关键字，禁止指令的重排序优化
 *
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class SynchronizedLazy3 {

    private static volatile SynchronizedLazy3 synchronizedLazy2 = null;

    private SynchronizedLazy3() {

    }

    public static SynchronizedLazy3 getInstance() {
        if (synchronizedLazy2 == null) {
            synchronized (SynchronizedLazy3.class) {
                if (synchronizedLazy2 == null) {
                    synchronizedLazy2 = new SynchronizedLazy3();
                }
            }
        }
        return synchronizedLazy2;
    }
}
