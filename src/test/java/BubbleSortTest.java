import java.util.Arrays;

/**
 * @Author ZhangGJ
 * @Date 2019/10/18
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {12, 2, 56, 4, 16, 9, 3, 34, 11, 22};
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1]) {
                    int n = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = n;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
