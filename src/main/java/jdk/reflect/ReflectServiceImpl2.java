package jdk.reflect;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name){
        this.name = name;
    }

    public void sayHellollo(){
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) throws Exception{
        ReflectServiceImpl2 object = (ReflectServiceImpl2)Class.forName("reflect.ReflectServiceImpl2")
                .getConstructor(String.class)
                .newInstance("张三");
        System.out.println(object);
    }


}
