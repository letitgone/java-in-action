package jdk.reflect;

public class ReflectServiceImpl {
    public void sayHello(String name){
        System.out.println("Hello " + name);
    }

    public void mike(int i){
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception{
        ReflectServiceImpl object = (ReflectServiceImpl)Class.forName("reflect.ReflectServiceImpl").newInstance();
        System.out.println(object);
    }
}
