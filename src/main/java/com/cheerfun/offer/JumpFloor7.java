package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname JumpFloor7
 *  * @Author fangzhou
 *  * @Date 2020/4/29 6:58 下午
 *  * @Version V1.0
 *  
 */
public class JumpFloor7 {
    public int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[target];
    }
}
