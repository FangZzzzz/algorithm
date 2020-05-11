package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname MoreThanHalfNum_Solution
 *  * @Author fangzhou
 *  * @Date 2020/5/3 10:07 下午
 *  * @Version V1.0
 *  
 */
public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {
        new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int cur = array[0], curSum = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == cur) {
                curSum++;
            } else if (curSum == 0) {
                cur = array[i];
                curSum++;
            } else {
                curSum--;
            }
        }
        curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (cur == array[i]) {
                curSum++;
            }
        }
        if (curSum >= array.length / 2 + 1) {
            return cur;
        }
        return 0;
    }
}
