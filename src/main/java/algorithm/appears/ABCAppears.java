package algorithm.appears;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhangGJ
 * @Date 2019/10/25
 * <p>
 * 单词出现的次数
 */
public class ABCAppears {

    private static final String regex = "[a-zA-Z]*" ;

    private static final Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        File file = new File(
            "/Users/zhanggengjia/Downloads/IntellijProject/java_in_action/src/main/resources/Article");
        InputStream in = null;
        int i;
        int total = 0;
        String article = "" ;
        try {
            try {
                in = new FileInputStream(file);
                /*
                 * 从输入流中读取数据的下一个字节。返回 0 到 255 范围内的 int 字节值。如果因为已经到达流末尾而没有可用的字节，则返回值 -1
                 */
                while ((i = in.read()) != -1) {
                    String s = String.valueOf((char) i);
                    article += s;
                    total++;
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(article);
        System.out.println("Total: " + total);

        Map<String, Integer> map = new HashMap<>();

        int num = 1;
        char[] words = article.toCharArray();
        System.out.println(Arrays.toString(words));
        for (int j = 0; j < words.length; j++) {
            ///           在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度
            //            错误用法： Pattern pattern = Pattern.compile("[a-zA-Z]*");
            Matcher matcher = pattern.matcher(String.valueOf(words[j]));
            if (!matcher.matches()) {
                continue;
            }
            if (!map.containsKey(String.valueOf(words[j]))) {
                map.put(String.valueOf(words[j]), num);
            } else {
                Integer value = map.get(String.valueOf(words[j]));
                map.put(String.valueOf(words[j]), value + 1);
            }
        }
        System.out.println(map.toString());
    }
}
