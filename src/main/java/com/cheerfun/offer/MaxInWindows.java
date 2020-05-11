package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  * @Description TODO
 *  * @Classname MaxInWindows
 *  * @Author fangzhou
 *  * @Date 2020/5/8 10:30 下午
 *  * @Version V1.0
 *  
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return result;
        }
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }
}
