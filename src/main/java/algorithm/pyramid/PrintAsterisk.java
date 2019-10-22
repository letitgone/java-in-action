package algorithm.pyramid;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 *
 *          *
 *         ***
 *        *****
 *       *******
 *      *********
 *     ***********
 *    *************
 *   ***************
 *  *****************
 * *******************
 */
public class PrintAsterisk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {   //控制行数
            for (int j = 0; j < n - i; j++) {   //每行要打印的空格数
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++) {   //每行要打印的符号的个数（相对于前一行多两个）
                System.out.print("*");
            }
            System.out.print("\n");   //换行打印
        }
    }
}
