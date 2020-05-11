package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname LeftRotateString
 *  * @Author fangzhou
 *  * @Date 2020/5/4 3:00 下午
 *  * @Version V1.0
 *  
 */
public class LeftRotateString {

    public static String LeftRotateString(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length());
        if (str == null || str.length() == 0) {
            sb.toString();
        }
        n = n % str.length();
        String before = str.substring(0, n);
        String after = str.substring(n);
        return sb.append(before).append(after).toString();
    }
}
