package StackTree;

/**
 * Created by Andrew_wl on 2017/11/14.
 */

public class StraightInsertSort {
    //直接插入排序
    public void straightInsertSort(int[] array) {
        int length = array.length;
        int soldier, i, j;
        for (i = 1; i < length; i++) {
            if (array[i - 1] > array[i]) {
                soldier = array[i];//设置哨兵
                for (j = i - 1; j >= 0 && array[j] > soldier; j--)
                    array[j + 1] = array[j];
                array[j + 1] = soldier;
            }
        }
    }

    public static void main(String[] args) {
        StraightInsertSort s = new StraightInsertSort();
        int[] a = {5, 3, 4, 6, 2};
        s.straightInsertSort(a);
        for (int n : a) System.out.print(n);
    }
}
