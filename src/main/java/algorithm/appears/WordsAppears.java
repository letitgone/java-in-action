package algorithm.appears;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhangGJ
 * @Date 2019/10/25
 * <p>
 * 文件单词出现的次数
 */
public class WordsAppears {

    private static final String regex = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“\"’。，、？]";

    private static final String replace = "";

    public static void main(String[] args) {
        File file = new File("/Users/zhanggengjia/Downloads/IntellijProject/java_in_action/src/main/resources/Article");
        String s = "";
        int i;
        InputStream in = null;
        try {
            try {
                in = new FileInputStream(file);
                while ((i = in.read()) != -1) {
                    s += String.valueOf((char)i);
                }
                System.out.println(s);
            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        String newString = m.replaceAll(replace).trim();
        System.out.println("newString: " + newString);
        String[] arrays = newString.split(" ");
        System.out.println("Array: " + Arrays.toString(arrays));
        Map<String, Integer> map = new HashMap<>();
        int value = 1;
        for (String word : arrays) {
            if(!map.containsKey(word)){
                map.put(word, value);
            } else {
                int values = map.get(word);
                map.put(word, values + 1);
            }
        }
        System.out.println("Result: " + map.toString());
    }
}
