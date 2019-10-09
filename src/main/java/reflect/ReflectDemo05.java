package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo05 {

	public static void main(String[] args) throws Exception{
		//泛型属于编译时的类型
		ArrayList<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);//不能这么做
		//通过动态调用将100写入到集合.
		Class<?> c=list.getClass();
		Method m = c.getDeclaredMethod("add", Object.class);
		m.invoke(list,100);
		System.out.println(list);
	}
}
