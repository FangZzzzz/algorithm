package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname ReverseSentence
 *  * @Author fangzhou
 *  * @Date 2020/5/4 3:08 下午
 *  * @Version V1.0
 *  
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return new String();
        }
        char[] chars = str.toCharArray();
        reversChars(chars, 0, chars.length - 1);
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reversChars(chars, start, i - 1);
                start = i + 1;
            }
        }
        reversChars(chars, start, chars.length - 1);
        return new String(chars);
    }

    private void reversChars(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
