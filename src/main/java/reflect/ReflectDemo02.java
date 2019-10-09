package reflect;

import java.util.Scanner;

public class ReflectDemo02 {
	public static void main(String[] args)throws Exception {
      System.out.println("please input class:");
	  Scanner sc=new Scanner(System.in);
	  String className=sc.nextLine();
	  //根据输入的类名构建对象
	  Class<?> c1=Class.forName(className);
	  System.out.println(c1);
	  Object obj=c1.newInstance();
	  System.out.println(obj);
	  sc.close();
	}//测试:java.util.Date
}
