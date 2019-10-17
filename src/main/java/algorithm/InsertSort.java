package algorithm;

import java.util.Arrays;

/**
 * @Author ZhangGJ
 * @Date 2019/09/23
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * @param arr  待排序数组
     */
    public static void insertionSort(int[] arr){
        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];      //交换操作
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {36,25,48,12,25,65,43,57};
        insertionSort(a);
    }
}
