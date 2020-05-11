package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname FirstAppearingOnce
 *  * @Author fangzhou
 *  * @Date 2020/5/4 4:29 下午
 *  * @Version V1.0
 *  
 */
public class FirstAppearingOnce {

    private int[] ana = new int[127];
    private int index = 0;


    {
        for (int i = 0; i < ana.length; i++) {
            ana[i] = -1;
        }
    }

    public void Insert(char ch) {
        if (ana[ch] == -1) {
            ana[ch] = index;
        } else if (ana[ch] > -1) {
            ana[ch] = -2;
        }
        index++;
    }

    public char FirstAppearingOnce() {
        char ch = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ana.length; i++) {
            if (ana[i] >= 0 && min > ana[i]) {
                ch = (char) i;
                min = ana[i];
            }
        }
        return ch;
    }
}
