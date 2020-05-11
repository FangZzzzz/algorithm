package com.cheerfun.sort;

/**
 *  * @Description TODO
 *  * @Classname MergeSort
 *  * @Author fangzhou
 *  * @Date 2020/5/9 11:15 上午
 *  * @Version V1.0
 *  
 */
public class MergeSort {


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{3, 2, 1, 9, 5, 6, 7, 8};
        mergeSort.sort(arr);
        for (int i :
                arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }


    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= left && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
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
    }
}
