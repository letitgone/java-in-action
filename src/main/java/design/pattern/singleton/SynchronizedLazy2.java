package design.pattern.singleton;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 单例模式--懒汉模式（线程安全）
 */
public class SynchronizedLazy2 {

    private static SynchronizedLazy2 synchronizedLazy2 = null;

    private SynchronizedLazy2(){

    }

    public static SynchronizedLazy2 getInstance(){
        synchronized (SynchronizedLazy2.class){
            if(synchronizedLazy2 == null){
                synchronizedLazy2 = new SynchronizedLazy2();
            }
            return synchronizedLazy2;
        }
    }
}
