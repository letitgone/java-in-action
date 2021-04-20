package design.pattern.singleton;

/**
 * 静态内部类
 *
 * @Author ZhangGJ
 * @Date 2021/04/20 11:48
 */
public class SynchronizedLazy4 {

    private static class SingletonHolder {
        public static SynchronizedLazy4 synchronizedLazy4 = new SynchronizedLazy4();
    }

    private SynchronizedLazy4() {

    }

    public static SynchronizedLazy4 newInstance() {
        return SingletonHolder.synchronizedLazy4;
    }
}
