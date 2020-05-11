package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *  * @Description TODO
 *  * @Classname Permutation
 *  * @Author fangzhou
 *  * @Date 2020/5/2 4:42 下午
 *  * @Version V1.0
 *  
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        TreeSet<String> treeSet = new TreeSet<>();
        char[] chars = str.toCharArray();
        PermutationHelper(chars, 0, treeSet);
        result.addAll(treeSet);
        return result;
    }

    private void PermutationHelper(char[] chars, int begin, TreeSet<String> treeSet) {
        if (begin == chars.length - 1) {
            treeSet.add(new String(chars));
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            PermutationHelper(chars, begin + 1, treeSet);
            swap(chars, begin, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
