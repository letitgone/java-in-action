package reflect;

class Student{
	private String name;
	private int age;
	public Student(String name){
		this.name=name;
	}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setName(String name) {
		this.name = name;
	}
}
