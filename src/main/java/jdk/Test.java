package jdk;

public class Test {
		public static void main(String[] args) throws Exception{
			Thread t = new Thread(){
				@Override
				public void run(){
					methodB();
				}
			};
			t.run();
			System.out.println("456");
		}
		static void methodB(){
			System.out.println("123");
		}
}
