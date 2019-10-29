package algorithm.recursive.factorial;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/22
 * 
 * 阶乘
 */
public class MyFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println(sum);
    }
}
