package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname InversePairs
 *  * @Author fangzhou
 *  * @Date 2020/5/9 11:43 上午
 *  * @Version V1.0
 *  
 */
public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSortAndCountSwap(array, 0, array.length - 1);
    }

    public int mergeSortAndCountSwap(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = mergeSortAndCountSwap(arr, left, mid);
        int rightCount = mergeSortAndCountSwap(arr, mid + 1, right);
        return (mergeAndCountSwap(arr, left, mid, right) + leftCount + rightCount) % 1000000007;
    }

    public int mergeAndCountSwap(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
        return count;
    }

}
