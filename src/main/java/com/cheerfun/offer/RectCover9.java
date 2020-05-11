package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname RectCover9
 *  * @Author fangzhou
 *  * @Date 2020/4/29 7:13 下午
 *  * @Version V1.0
 *  
 */
public class RectCover9 {
    public int RectCover(int target) {
        if (target < 3) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }
        return dp[target];
    }
}
