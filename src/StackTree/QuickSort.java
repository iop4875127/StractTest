package StackTree;

/**
 * Created by Andrew_wl on 2017/11/15.
 */

public class QuickSort {
    //快速排序
    //找一个分割点part，part左边的数小于part，右边的数大于part，依次规则，
    // 将子序列的首个数字设置成一个哨兵，将它与该子序列的其他元素进行比较交换，
    // 使得整个子序列最终的排序结果为：哨兵左边的数小于哨兵，右边的数大于哨兵，返回part的下标；
    //然后以part下标为分割点将序列分为左右两个子序列。
    //依次对左右子序列进行寻找分割点、分割成更小的子序列的操作，直到序列不能再分割。
    public void quickSort(int[] array) {
        int length = array.length;
        QSort(array, 0, length - 1);
    }

    public void QSort(int[] array, int low, int high) {
        int partIndex;
        if (low < high) {
            partIndex = getPartIndex(array, low, high);
            QSort(array, low, partIndex);
            QSort(array, partIndex + 1, high);
        }
    }

    public int getPartIndex(int[] array, int low, int high) {
        int soldier = array[low];
        while (low < high) {
            while (low < high && array[high] >= soldier)
                high--;
            swap(array, low, high);
            while (low < high && array[low] <= soldier)
                low++;
            swap(array, low, high);
        }
        return low;
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}