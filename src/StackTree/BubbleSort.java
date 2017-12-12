package StackTree;

/**
 * Created by Andrew_wl on 2017/10/14.
 */
/*
* 优化的冒泡排序
* 如果数组i之后元素之间没有发生交换，那么说明i之后的元素已经排好序了，此时flag标记为false，
* 数组排序结束，否则继续进行比较、交换。
* */

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int length = array.length;
        boolean flag = true;
        for (int i = 0; i < length-1 && flag; i++) {
            flag = false;
            for (int j = length-2; j >=i; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        BubbleSort bubbleSort=new BubbleSort();
        int[] a={5,2,3,4,1};
        bubbleSort.bubbleSort(a);
        for (int n:a)System.out.println(n);
    }
}