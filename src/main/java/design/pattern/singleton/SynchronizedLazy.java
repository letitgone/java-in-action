package design.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 单例模式--懒汉模式（线程安全）
 */
public class SynchronizedLazy {

    private static SynchronizedLazy synchronizedLazy = null;

    public Map<String, String> map = null;

    private SynchronizedLazy(){
        map = new HashMap<>();
        map.put("1","3");
    }

    public static synchronized SynchronizedLazy getInstance(){
        if(synchronizedLazy == null){
            synchronizedLazy = new SynchronizedLazy();
        }
        return synchronizedLazy;
    }
}
