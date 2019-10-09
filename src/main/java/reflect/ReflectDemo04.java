package reflect;

import java.lang.reflect.Method;

public class ReflectDemo04 {
	public static void main(String[] args)throws Exception {
	   Class<?> c1=Class.forName("Teacher");
	   Object obj1=c1.newInstance();
	   //通过类对象获得方法对象
	   Method m1= c1.getDeclaredMethod("setName",String.class);
	   //执行方法对象(动态执行)
	   //执行obj1对象的m1方法,传参为"苍松"
	   Object result=m1.invoke(obj1,"苍松"); //动态的执行m1方法
	   Method m2= c1.getDeclaredMethod("getName");
	   //执行obj1对象的m2方法
	   result=m2.invoke(obj1); //动态的执行m2方法
	   System.out.println(result);
	}
}


