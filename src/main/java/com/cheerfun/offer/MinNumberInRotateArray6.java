package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname MinNumberInRotateArray6
 *  * @Author fangzhou
 *  * @Date 2020/4/28 11:20 下午
 *  * @Version V1.0
 *  
 */
public class MinNumberInRotateArray6 {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        int mid = 0;
        // 确保子集还是旋转的
        while (array[l] >= array[r]) {
            if (l == r - 1) {
                mid = r;
                break;
            }
            mid = l + (r - l) / 2;
            if (array[l] == array[r] && array[mid] == array[l]) {
                return orderFind(array, l, r);
            }
            // mid位于左边顺序区间
            if (array[l] < array[mid]) {
                l = mid;
            } else {
                // mid位于右边顺序区间
                r = mid;
            }
        }
        return mid;
    }

    private int orderFind(int[] array, int l, int r) {
        for (int i = l; i < r; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[l];
    }
}
