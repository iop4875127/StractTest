package StackTree;

/**
 * Created by Andrew_wl on 2017/11/15.
 */

public class MergeSort {
    //归并排序
    public void mergeSort(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        int k = 1;
        while (k < length) {
            //将array序列分割成若干长度为k的子序列，再将这些子序列两两合并，放进序列newArray
            MergePass(array, newArray, k, length);
            //长度k加倍
            k = k * 2;
            //将进行过一轮排序以及合并后的序列newArray再分割成若干长度为k的子序列，再将这些子序列两两合并，放进序列Array
            MergePass(newArray, array, k, length);
            //长度k再加倍
            k = k * 2;
        }
    }

    public void MergePass(int[] array, int[] newArray, int dis, int length) {
        int i = 0;
        /*
        * 情况1：按长度为dis来分割整个序列array，分割过程中当剩余的序列array长度>=2dis时，
        * 可以进行分割归并，如下
        * */
        while (i <= length - 2 * dis) {
            Marge(array, newArray, i, i + dis - 1, i + 2 * dis - 1);
            i = i + dis * 2;
        }
        /*
        *情况2：分割过程中当最后剩余的序列array长度在(dis,2dis)范围时，将序列仅且分为2个子序列，
        *  一个长度为dis,另一个长度不足dis，将两个子序列进行归并
        * */
        if (i < length - dis)
            Marge(array, newArray, i, i + dis - 1, length - 1);
        /*
        * 情况3：分割过程中当最后剩余的序列array长度在<dis时,那么只有一个长度不足dis的子序列，
        * 无法进行归并，则剩下的这个子序列直接添加进newArray末尾
        * */
        else
            for (int j = i; j < length; j++) {
                newArray[j] = array[j];
            }
    }

    public void Marge(int[] array, int[] newArray, int i, int mid, int last) {
        int k = i;//newArray下标k
        int j = mid + 1;
        //待合并的两个子序列array[i,mid]和array[mid+1,last]的元素逐个进行比较，
        // 从小到大依次存入newArray数组里面，算是完成了两个子序列的合并
        for (; i <= mid && j <= last; k++) {
            if (array[i] < array[j]) newArray[k] = array[i++];
            else newArray[k] = array[j++];
        }
        //上述比较过后，将第一个子序列的剩余元素存入newArray
        if (i <= mid)
            for (int l = i; l <= mid; l++)
                newArray[k++] = array[l];
        //上述比较过后，将第二个子序列的剩余元素存入newArray
        if (j <= last)
            for (int l = j; l <= last; l++)
                newArray[k++] = array[l];
    }
}