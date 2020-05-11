package com.cheerfun.offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname MinStack
 *  * @Author fangzhou
 *  * @Date 2020/5/2 1:36 下午
 *  * @Version V1.0
 *  
 */
public class MinStack {

    private Stack<Integer> baseStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        baseStack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (baseStack.isEmpty()) {
            throw new EmptyStackException();
        }
        Integer pop = baseStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (baseStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return baseStack.peek();
    }

    public int min() {
        if (baseStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }
}
