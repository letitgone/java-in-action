package reflect;

public class ReflectDemo01 {
    public static void main(String[] args)throws Exception {
    	//编译时就已经确定会构建哪个类的对象
    	//这个过程我们称之为静态过程.
		Point p1=new Point();//类的实例(类的对象)
		
		//获取Point类的类对象
		Class<?> c1=p1.getClass();
		Class<?> c2= Point.class;
		//重点记住如下类的加载方式
		Class<?> c3=Class.forName("Point");
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);//true
		System.out.println(c3);
		//FAQ 类加载时会有对应的加载器,如何
		//发现此类对应的类加载器是谁?(了解)
		
		ClassLoader loader= c3.getClassLoader();
		System.out.println(loader);//AppClassLoader
		ClassLoader pLoader=loader.getParent();
		System.out.println(pLoader);//ExtClassLoader
		ClassLoader ppLoader=pLoader.getParent();
		System.out.println(ppLoader);//null (BootstarpClassLoader)
		
		//各加载器的职责(了解)
		//1)BootstarpClassLoader (jdk/jre/lib包中的jar文件)
		//2)ExtClassLoader(jdk/jre/lib/ext包中的jar文件)
		//3)AppClassLoader(自己写的类)
		//类加载器扩展:我们也可以自己定义类加载器(继承ClassLoader)
		
		
		
	}
}




