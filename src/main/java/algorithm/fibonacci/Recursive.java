package algorithm.fibonacci;

/**
 * 斐波那契数列（递归）
 *
 * @Author ZhangGJ
 * @Date 2020/01/01 08:43
 */
public class Recursive {

    public static int fibonacci(int i) {
        if (i <= 2) {
            return 1;
        }
        return fibonacci(i - 2) + fibonacci(i - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        if (n < 0) {
            System.out.println("Cannot use negative numbers");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
