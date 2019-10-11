/**
 * @Author ZhangGJ
 * @Date 2019/10/10
 */
public class Test1 extends Test{

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


    public void Test(int i){
        System.out.printf("IIII");
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("hello");
    }
}
