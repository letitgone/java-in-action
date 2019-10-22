package algorithm.pyramid;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 *
 *      1
 *     121
 *    12321
 *   1234321
 *  123454321
 * 12345654321
 */
public class PrintSymNum_mine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n - i; i++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= n; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
