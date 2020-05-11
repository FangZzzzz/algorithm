package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname FindGreatestSumOfSubArray
 *  * @Author fangzhou
 *  * @Date 2020/5/4 10:49 上午
 *  * @Version V1.0
 *  
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max + array[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
