/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 *
 * void 方法可以return，但是return后不能有任何东西
 *
 * 子类不能调用，重写父类的构造器
 */
public class Test {

    private int i;

    public Test(){

    }

    public Test(int i){
        this.i = i;
    }

    public String getString(){
        return "hello!";
    }
    public static void main(String[] args) {
        System.out.println("test!");
    }
}
