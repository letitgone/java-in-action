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
 * https://www.jianshu.com/p/292f4e346b5d
 */
public class ABCAppears {

    private static final String regex = "[a-zA-Z]*" ;

    private static final Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        File file = new File(
            "/Users/zhanggengjia/Downloads/IntellijProject/java-in-action/src/main/resources/Article");
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
//            method 1:
//            if (!map.containsKey(String.valueOf(words[j]))) {
//                map.put(String.valueOf(words[j]), num);
//            } else {
//                Integer value = map.get(String.valueOf(words[j]));
//                map.put(String.valueOf(words[j]), value + 1);
//            }
//            {A=1, F=1, J=1, S=3, T=1, a=25, b=3, c=14, d=8, e=38, f=10, g=8, h=6, i=29, k=3, l=16, m=13, n=32, o=30, p=23, r=23, s=23, t=25, u=10, v=6, w=2, y=5}
//            method 2:
//            map.put(String.valueOf(words[j]), map.getOrDefault(String.valueOf(words[j]),0) + 1);
//            {A=1, F=1, J=1, S=3, T=1, a=25, b=3, c=14, d=8, e=38, f=10, g=8, h=6, i=29, k=3, l=16, m=13, n=32, o=30, p=23, r=23, s=23, t=25, u=10, v=6, w=2, y=5}
////            method 3:
//            putIfAbsent   如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
//            map.putIfAbsent(String.valueOf(words[j]), 0);
//            map.put(String.valueOf(words[j]), map.get(String.valueOf(words[j])) + 1);
//            {A=1, F=1, J=1, S=3, T=1, a=25, b=3, c=14, d=8, e=38, f=10, g=8, h=6, i=29, k=3, l=16, m=13, n=32, o=30, p=23, r=23, s=23, t=25, u=10, v=6, w=2, y=5}
////            method 4:
            map.merge(String.valueOf(words[j]), 1, Integer::sum);
//            {A=1, F=1, J=1, S=3, T=1, a=25, b=3, c=14, d=8, e=38, f=10, g=8, h=6, i=29, k=3, l=16, m=13, n=32, o=30, p=23, r=23, s=23, t=25, u=10, v=6, w=2, y=5}
        }
        System.out.println(map.toString());
    }
}
