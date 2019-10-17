package algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * @Author ZhangGJ
 * @Date 2019/09/23
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * @param arr  待排序数组
     */
    public static void bubbleSort(int[] arr){
        /*
        外层循环移动游标
         */
        for (int i = arr.length - 1; i > 0; i--) {
            /*
            内层循环遍历游标及之后(或之前)的元素
             */
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {36,25,48,12,25,65,43,57};
        bubbleSort(a);
    }
}
