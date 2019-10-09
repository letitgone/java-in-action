package design.pattern.singleton;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 单例模式--懒汉模式（线程安全）
 */
public class SynchronizedLazy {

    private static SynchronizedLazy synchronizedLazy = null;

    private SynchronizedLazy(){

    }

    public static synchronized SynchronizedLazy getInstance(){
        if(synchronizedLazy == null){
            synchronizedLazy = new SynchronizedLazy();
        }
        return synchronizedLazy;
    }
}
