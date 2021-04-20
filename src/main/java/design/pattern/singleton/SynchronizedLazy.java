package design.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式--懒汉模式（线程安全）
 * 解决了懒汉模式的线程安全问题
 * 问题：全剧唯一实例锁，有可能成为系统的瓶颈
 *
 * @Author ZhangGJ
 * @Date 2019/10/08
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
