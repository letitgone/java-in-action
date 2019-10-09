package jdk.interceptor;

public class MyInterceptorTest {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy
            .bind(new HelloWorldImpl(),"interceptor.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
