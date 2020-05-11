package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  * @Description TODO
 *  * @Classname GetLeastNumbers_Solution
 *  * @Author fangzhou
 *  * @Date 2020/5/3 10:19 下午
 *  * @Version V1.0
 *  
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>(k);
        if (input == null || input.length < k || k <= 0) {
            return result;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (maxheap.size() < k) {
                maxheap.offer(input[i]);
            } else if (maxheap.peek() > input[i]) {
                maxheap.poll();
                maxheap.offer(input[i]);
            }
        }
        result.addAll(maxheap);
        return result;
    }
}
