package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * @Description TODO
 *  * @Classname FirstNotRepeatingChar
 *  * @Author fangzhou
 *  * @Date 2020/5/4 11:40 上午
 *  * @Version V1.0
 *  
 */
public class FirstNotRepeatingChar {


    public int FirstNotRepeatingChar(String str) {
        int[] map = new int[128];
        int result = -1;
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (map[str.charAt(i)] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
