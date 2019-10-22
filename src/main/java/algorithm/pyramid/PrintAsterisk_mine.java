package algorithm.pyramid;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 * <p>
 * 打印：
 * *
 * ***
 * *****
 * *******
 * *********
 * ***********
 * *************
 * ***************
 * *****************
 * *******************
 * *********************
 */
public class PrintAsterisk_mine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = "*";
        String t = " ";
        if(n == 1){
            System.out.println(s);
            return;
        }
        System.out.println(s);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i + i - 1; j++) {
                System.out.print(s);
            }
            System.out.println();
        }

    }
}
