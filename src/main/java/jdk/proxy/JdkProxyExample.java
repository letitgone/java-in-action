package jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    private Object target = null; //真实对象

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this); //返回代理对象
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真是对象之前的服务");
        Object obj = method.invoke(target,args);
        System.out.println("在调度真是对象之后的服务");
        return obj;
    }

}
