/**
 * @Author ZhangGJ
 * @Date 2019/10/17
 */
public class IntegerInt {
    public static void main(String[] args) {

        int j1 = 58;
        int j2 = 107;
        j1 += 1;

        Integer i1 = 56;
        i1 += 2;
        System.out.println(i1);

        Integer i2 = new Integer(45);
        i2 += 4;
        System.out.println(i2);

        i2 += i1;
        System.out.println(i2);

        System.out.println(j1 == i1);

        System.out.println("================");

        Integer a = 100, b = 100, c = new Integer(100);
        int d = 100;
        System.out.println(a == b); //true
        System.out.println(a == c); // false
        System.out.println(a == d); // false

    }
}
