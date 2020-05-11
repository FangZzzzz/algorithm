package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname ReplaceSpace
 *  * @Author fangzhou
 *  * @Date 2020/4/28 8:31 下午
 *  * @Version V1.0
 *  
 */
public class ReplaceSpace2 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return str.toString();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result .append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
