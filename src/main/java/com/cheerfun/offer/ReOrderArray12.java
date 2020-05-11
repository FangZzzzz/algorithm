package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname reOrderArray
 *  * @Author fangzhou
 *  * @Date 2020/4/29 7:55 下午
 *  * @Version V1.0
 *  
 */
public class ReOrderArray12 {
    public void reOrderArray(int[] array) {
        if (array == null) {

        }
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int j = i;
                while (j > k) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j--;
                }
                k ++;
            }
        }
    }
}
