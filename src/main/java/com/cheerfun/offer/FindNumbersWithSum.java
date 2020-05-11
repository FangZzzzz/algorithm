package com.cheerfun.offer;

import java.util.ArrayList;

/**
 *  * @Description TODO
 *  * @Classname FindNumbersWithSum
 *  * @Author fangzhou
 *  * @Date 2020/5/4 2:55 下午
 *  * @Version V1.0
 *  
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null) {
            return result;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int tempSum = array[l] + array[r];
            if (sum == tempSum) {
                result.add(array[l]);
                result.add(array[r]);
                break;
            } else if (sum > tempSum) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
