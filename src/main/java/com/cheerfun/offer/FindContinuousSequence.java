package com.cheerfun.offer;

import java.util.ArrayList;

/**
 *  * @Description TODO
 *  * @Classname FindContinuousSequence
 *  * @Author fangzhou
 *  * @Date 2020/5/4 2:43 下午
 *  * @Version V1.0
 *  
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        new FindContinuousSequence().FindContinuousSequence(100);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r) {
            int tempSum = (l + r) * (r - l + 1) / 2;
            if (tempSum == sum) {
                ArrayList<Integer> list = new ArrayList<>(sum - tempSum + 1);
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                result.add(list);
                l++;
            }
            if (tempSum < sum) {
                r++;
            }
            if (tempSum > sum) {
                l++;
            }
        }
        return result;
    }
}
