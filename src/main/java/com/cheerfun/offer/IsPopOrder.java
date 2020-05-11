package com.cheerfun.offer;

import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname IsPopOrder
 *  * @Author fangzhou
 *  * @Date 2020/5/2 1:55 下午
 *  * @Version V1.0
 *  
 */
public class IsPopOrder {


    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA != null && popA == null) {
            return false;
        }
        if (pushA == null && popA != null) {
            return false;
        }
        if (pushA == null && popA == null) {
            return true;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(j < popA.length && popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
