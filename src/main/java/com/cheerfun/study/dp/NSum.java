package com.cheerfun.study.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *  * @Description TODO
 *  * @Classname NSum
 *  * @Author fangzhou
 *  * @Date 2020/6/10 9:18 下午
 *  * @Version V1.0
 *  
 */
public class NSum {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        NSum nSum = new NSum();
        nSum.nSum(new int[]{3, 2, 1, 4, 5, 6, 2, 2}, 6, 3, 0, new ArrayList<>(), 0);
        System.out.println("aaa");
    }



    public void nSum(int[] nums, int target, int needCount, int beginIndex, List<Integer> memo, int sum) {
        if (needCount == 0 && sum == target) {
            result.add(new ArrayList<>(memo));
            return;
        }
        for (int i = beginIndex; i < nums.length; i++) {
            if (nums[i] + sum > target) {
                continue;
            }
            memo.add(nums[i]);
            nSum(nums, target, needCount - 1, i + 1, memo, sum + nums[i]);
            memo.remove(memo.size() - 1);
        }
    }

}
