package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname FindNumsAppearOnce
 *  * @Author fangzhou
 *  * @Date 2020/5/4 2:01 下午
 *  * @Version V1.0
 *  
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{1, 1, 3, 6}, new int[1], new int[1]);
    }


    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int yihouResult = 0;
        for (int i = 0; i < array.length; i++) {
            yihouResult ^= array[i];
        }
        int temp = 1;
        while ((yihouResult & temp) != 1) {
            temp <<= 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & temp) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

}
