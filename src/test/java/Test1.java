/**
 * @Author ZhangGJ
 * @Date 2019/10/10
 */
public class Test1 extends Test{

    public Test1(){
        System.out.println("4444");

    }

    public Test1(String s , int i){
        System.out.printf("");
    }

    public Test1(double d){
        this("2",8);
        System.out.println("5555");
    }



    public void string(){
        getString();
    }

    @Override
    public String getString(){
        Test(1);
        int i = 0;
        i++;
        System.out.println(i);
        return String.valueOf(i);
    }

    public static void tripleValue(double x){
        x = 3 * x;
    }




    public void Test(int i){
        System.out.printf("IIII");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1(2);
        Test test = new Test();
        System.out.println("hello");

        double d = 10;
        tripleValue(d);
        System.out.println(d);
    }
}
