package StackTree;

/**
 * Created by Andrew_wl on 2017/11/15.
 */

public class ShellSort {
    //希尔排序：设置增量，将序列分割成几个子序列，分别对子序列进行“直接插入排序”，使整个序列基本有序；
    // 最后increment=1再对整个序列进行直接插入排序。
    public void shellSort(int[] array) {
        int length = array.length;
        int increment = length;
        int soldier, i, j;
        do {
            increment = increment / 3 + 1;
            for (i = increment; i < length; i += increment) {
                if (array[i - increment] > array[i]) {
                    soldier = array[i];
                    for (j = i - increment; j >= 0 && array[j] > soldier; j -= increment)
                        array[j + increment] = array[j];
                    array[j + increment] = soldier;
                }
            }
        } while (increment > 1);
    }

}