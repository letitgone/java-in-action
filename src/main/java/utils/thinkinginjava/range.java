package utils.thinkinginjava;

/**
 * 生成数组
 * @Author ZhangGJ
 * @Date 2020/01/01 06:32
 */
public class range {
    public static int[] range(int n) {
        int[] result = new int[n];

        for(int i = 0; i < n; result[i] = i++) {
        }

        return result;
    }

    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] result = new int[sz];

        for(int i = 0; i < sz; ++i) {
            result[i] = start + i;
        }

        return result;
    }

    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int[] result = new int[sz];

        for(int i = 0; i < sz; ++i) {
            result[i] = start + i * step;
        }

        return result;
    }
}
