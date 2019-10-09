package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
    	//获得类对象
		Class<?> c1 = Class.forName("Student");
		//Object obj1=c1.newInstance();
		//通过类对象获得构造函数对象
		Constructor<?> con1 = c1.getDeclaredConstructor(String.class);
				/*
				首先看getDeclaredConstructor(Class<?>... parameterTypes)
				这个方法会返回制定参数类型的所有构造器，包括public的和非public的，当然也包括private的。
				getDeclaredConstructors()的返回结果就没有参数类型的过滤了。

				再来看getConstructor(Class<?>... parameterTypes)
				这个方法返回的是上面那个方法返回结果的子集，只返回制定参数类型访问权限是public的构造器。
				getConstructors()的返回结果同样也没有参数类型的过滤。
				 */
        System.out.println(con1);
		//通过构造函数对象构建类的对象
		Object ob1=con1.newInstance("王蒙");
		System.out.println(ob1);
		Constructor<?> con2= c1.getDeclaredConstructor( String.class,int.class);
        System.out.println(con2);
		Object obj2= con2.newInstance("祖红",18);
		System.out.println(obj2);
		//通过反射获得对象属性
		Field f1=c1.getDeclaredField("name"); //获得指定名字的属性（全部类型的修饰符的属性中指定名字）
		//Field[] fs=c1.getDeclaredFields();
        System.out.println(f1);
		//设置私有属性可访问
		f1.setAccessible(true);
		//获得obj2对象的f1属性的值
		Object f1Value=f1.get(obj2);
		System.out.println(f1Value);
		//设置Obj2对象的f1属性的值
		f1.set(obj2, "传奇");
		f1Value=f1.get(obj2);
		System.out.println(f1Value);
		Object f2Value = f1.get(ob1);
        System.out.println(f2Value);
        Field f2 = c1.getDeclaredField("age");
        f2.setAccessible(true);
        Object f3Value = f2.get(obj2);
        System.out.println(f3Value);
	}
}





