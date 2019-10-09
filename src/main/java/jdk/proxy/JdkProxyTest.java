package jdk.proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}
