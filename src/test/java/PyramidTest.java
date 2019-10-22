import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhangGJ
 * @Date 2019/10/22
 */
public class PyramidTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            System.out.println("请输入数字！");
            return;
        }
        long n = 0;
        try {
            n = Long.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("请输入正确范围的数字！");
            return;
        }
        if (n <= 0) {
            System.out.println("请输入正确的数字！");
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
//9223372036854775807
//100000000000000000000000000000000000000000000
