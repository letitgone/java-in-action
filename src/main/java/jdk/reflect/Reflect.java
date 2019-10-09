package jdk.reflect;

import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws Exception{
        ReflectServiceImpl object  = (ReflectServiceImpl)Class.forName("reflect.ReflectServiceImpl").newInstance();
        Method method = object.getClass().getMethod("sayHello",String.class);
        method.invoke(object,"张三");

        ReflectServiceImpl object1  = (ReflectServiceImpl)Class.forName("reflect.ReflectServiceImpl").newInstance();
        Method method1 = object1.getClass().getMethod("mike",int.class);
        method1.invoke(object1,10);
    }
}
