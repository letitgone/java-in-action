package jdk.reflect;

import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws Exception{
        ReflectServiceImpl target = new ReflectServiceImpl();
        Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
        Object returnObj = method.invoke(target,"张三"); //target就是确定用哪个对象调用方法

        ReflectServiceImpl target1 = new ReflectServiceImpl();
        Method method1 = ReflectServiceImpl.class.getMethod("mike",int.class);
        Object returnObj1 = method1.invoke(target,34); //target就是确定用哪个对象调用方法
    }
}
