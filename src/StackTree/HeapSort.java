package StackTree;

/**
 * Created by Andrew_wl on 2017/10/14.
 */

public class HeapSort {
    // 选择排序之堆排序:
    // 将无序序列{50,10,90,30,70,40,80,60,20}转换成{0,50,10,90,30,70,40,80,60,20}
    // 使原序列数字下标一次为1,2,3,4,5,6,7,8,9；
    // 1，将无序序列构建成一个大顶堆（大顶堆：任意结点的值大于其所有子结点的值）;
    // 2，结合完全二叉树性质，找出该大顶堆中的根结点（下标为在[1，length/2]范围的结点都是根结点）;
    // 3，将所有的根结点所在的子树构建成一个大顶堆;
    // 4，将整个无序序列构建成一个大顶堆后，将堆顶结点值与当前大顶堆最后一个结点值交换,
    // 此时大顶堆结构被破坏，再将[1,i-1]重构成大顶堆，i的初始值为length，之后重复步骤4;
    public void heapSort(int[] array) {
        int length = array.length;
        int i;
        int[] heapArray = new int[length + 1];
        System.arraycopy(array, 0, heapArray, 1, length);
        for (i = length / 2; i > 0; i--)
            HeapAdjust(heapArray, i, length);
        for (i = length; i > 1; i--) {
            swap(heapArray, 1, i);
            HeapAdjust(heapArray, 1, i - 1);
        }
        System.arraycopy(heapArray, 1, array, 0, length);
    }

    public void HeapAdjust(int[] array, int i, int length) {
        int root = array[i];
        for (int j = 2 * i; j <= length; j = 2 * j) {
            if (j < length && array[j + 1] > array[j])
                j = j + 1;
            if (root < array[j]) {
                array[i] = array[j];
                i = j;
            } else break;
        }
        array[i] = root;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}