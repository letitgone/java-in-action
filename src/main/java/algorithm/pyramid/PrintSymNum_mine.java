package algorithm.pyramid;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 */
public class PrintSymNum_mine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < n - j; i++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= j * 2 - 1; k++) {
                if(k > j){
                    for (int i = k - 2; i > 0; i--) {
                        System.out.print(i);
                    }
                    break;
                } else {
                    System.out.print(k);
                }
            }
            System.out.println();
        }
    }
}
