package number;

import java.text.DecimalFormat;

/**
 * 去掉double后面自动补0
 */
public class DoubleFormat {

    private static final String regex = "###################.#####################";

    public static void main(String[] args) {
        double d = 20300;
        System.out.println(new DecimalFormat(regex).format(d));
    }
}
