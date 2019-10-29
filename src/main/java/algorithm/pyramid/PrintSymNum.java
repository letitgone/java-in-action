package algorithm.pyramid;

import java.util.Scanner;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 *
 *         1
 *  *     121
 *  *    12321
 *  *   1234321
 *  *  123454321
 *  * 12345654321
 */
public class PrintSymNum {
    public static void main(String[] args) {
        System.out.println("请输入一个数字：");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();  //控制台输入一个整数
        for(int i = 1; i <= num; i++){   //行数为设定的那个数值
            for(int j = 0; j <= num-i;j++){   //空格站位
                System.out.print(" ");
            }
            for(int k = 1; k < i; k++){   //打印从1开始自增到设定的数
                System.out.print(k);
            }
            for(int m = i; m > 0 ; m--){   //打印从设定的数自减到1
                System.out.print(m);
            }
            System.out.print("\n");  //换行打印
        }
    }
}
