package algorithm.fibonacci;


import java.util.Arrays;

/**
 * 斐波那契数列（非递归）
 *
 * @Author ZhangGJ
 * @Date 2020/01/01 08:44
 */
public class NonRecursive {

    public static void fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            System.out.println(1);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i > 1) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr));
        return;
    }

    public static void main(String[] args) {
        int n = 10;
        if (n <= 0) {
            System.out.println("Cannot use negative numbers");
            return;
        }
        fibonacci(n);
    }
}
