package com.cheerfun.sort;


/**
 *  * @Description TODO
 *  * @Classname QuickSort
 *  * @Author fangzhou
 *  * @Date 2020/4/29 8:10 下午
 *  * @Version V1.0
 *  
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 6, 9, 8, 7, 1, 4, 5};
        new QuickSort().quickSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] array) {
        if (array == null) {
            return;
        }
        qSort(array, 0, array.length - 1);
    }

    private void qSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = divide(array, left, right);
            qSort(array, left, mid - 1);
            qSort(array, mid + 1, right);
        }
    }

    private int divide(int[] array, int left, int right) {
        int point = array[left];
        int pointIndex = left;
        while (left < right) {
            while (left < right && array[right] >= point) {
                right--;
            }
            while (left < right && array[left] <= point) {
                left++;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, pointIndex);
        return left;
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
