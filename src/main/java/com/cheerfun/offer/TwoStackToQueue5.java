package com.cheerfun.offer;

import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname TwoStackToQueue
 *  * @Author fangzhou
 *  * @Date 2020/4/28 9:19 下午
 *  * @Version V1.0
 *  
 */
public class TwoStackToQueue5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.empty()) {
            return stack2.pop();
        }
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
