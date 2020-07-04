package com.cheerfun.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  * @Description TODO
 *  * @Classname FindFirstMaxThenCur
 *  * @Author fangzhou
 *  * @Date 2020/7/2 11:31 下午
 *  * @Version V1.0
 *  
 */
public class FindFirstMaxThenCur {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,1,2,5};
        int[] result = findFirstMaxThenCur(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] findFirstMaxThenCur(int[] nums) {
        if (nums == null || nums.length ==0) {
            return null;
        }
        int len = nums.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int index = 1;
        while (index < len) {
            if (stack.isEmpty() || nums[index] < stack.peekLast()) {
                stack.addLast(index ++);
            } else {
                result[stack.removeLast()] = nums[index];
            }
        }
        while (!stack.isEmpty()) {
            result[stack.removeLast()] = -1;
        }
        return result;
    }
}
