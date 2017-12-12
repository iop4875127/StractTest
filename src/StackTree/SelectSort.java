package StackTree;

/**
 * Created by lenovo on 2017/9/6.
 */
/*
*简单选择排序
* 每轮比较过后，找出最小值的下标minIndex，如果i==minIndex，则找到最小值，不需要交换;
* 如果i!=minIndex，则需要交换i与minIndex位置的数值
* */

public class SelectSort {
    public void selectSort(int[] array){
        int length=array.length;
        int minIndex;
        for (int i=0;i<length-1;i++){
            minIndex=i;
            for (int j=i+1;j<length;j++){
                if (array[j]<array[minIndex])
                    minIndex=j;
            }
            if (minIndex!=i)
                swap(array,minIndex,i);
        }
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        SelectSort selectSort=new SelectSort();
        int[] a={5,2,3,4,1};
        selectSort.selectSort(a);
        for (int n:a)System.out.println(n);
    }
}
