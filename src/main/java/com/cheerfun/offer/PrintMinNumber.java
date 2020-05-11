package com.cheerfun.offer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 *  * @Description TODO
 *  * @Classname PrintMinNumber
 *  * @Author fangzhou
 *  * @Date 2020/5/4 11:00 上午
 *  * @Version V1.0
 *  
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[]{3, 323, 32123}));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        quickSort(numbers, 0, numbers.length - 1);
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start;
        int r = end;
        int point = arr[start];
        while (l < r) {
            while (l < r && compareTo(arr[r], point) > 0) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }
            while (l < r && compareTo(point, arr[l]) > 0) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }

        }
        arr[l] = point;
        quickSort(arr, start, l - 1);
        quickSort(arr, l + 1, end);
    }

    private int compareTo(int o1, int o2) {
        String beforeO1 = "" + o1 + o2;
        String beforeO2 = "" + o2 + o1;
        return (int) (Long.parseLong(beforeO1) - Long.parseLong(beforeO2));
    }
}
