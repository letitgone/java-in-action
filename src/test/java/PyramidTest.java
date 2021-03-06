import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhangGJ
 * @Date 2019/10/22
 *
 *            *
 *           ***
 *          *****
 *         *******
 *        *********
 *       ***********
 *      *************
 *     ***************
 *    *****************
 *   *******************
 */
public class PyramidTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(s);
        if(!matcher.matches()){
            System.out.println("请输入数字！");
            return;
        }
        long n = 0;
        try {
            n = Long.parseLong(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (n <= 0) {
            System.out.println("请输入正确的数字！");
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
