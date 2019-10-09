package jdk.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {
    public Object getProxy(Class cls){ //生成CGLIB代理对象
        Enhancer enhancer = new Enhancer(); //增强类对象
        enhancer.setSuperclass(cls); //设置增强类型
        enhancer.setCallback(this); //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        return enhancer.create(); //生成并返回代理对象

    }
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)throws Throwable{
        System.out.println("调用真实对象前");
        Object result = methodProxy.invokeSuper(proxy,args);
        System.out.println("调用真实对象后");
        return result;
    }
}
