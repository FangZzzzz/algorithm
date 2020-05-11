package com.cheerfun.offer;

import java.util.Arrays;

/**
 *  * @Description TODO
 *  * @Classname IsContinuous
 *  * @Author fangzhou
 *  * @Date 2020/5/4 3:29 下午
 *  * @Version V1.0
 *  
 */
public class IsContinuous {

    public static void main(String[] args) {

        System.out.println(isContinuous(new int[]{1,0,0,1,0}));
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int[] ana = new int[13];
        ana[0] = -4;
        int max = -1, min = 14;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num < 0 || num > 13 || ana[num] > 0) {
                return false;
            }
            if(num != 0) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            ana[num]++;
        }
        return max - min < 5;
    }
}
