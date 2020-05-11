package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname NumberOf1
 *  * @Author fangzhou
 *  * @Date 2020/4/29 7:23 下午
 *  * @Version V1.0
 *  
 */
public class NumberOf110 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
