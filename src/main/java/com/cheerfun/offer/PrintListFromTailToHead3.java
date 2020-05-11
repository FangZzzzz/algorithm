package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname PrintListFromTailToHead3
 *  * @Author fangzhou
 *  * @Date 2020/4/28 8:38 下午
 *  * @Version V1.0
 *  
 */
public class PrintListFromTailToHead3 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        printListFromTailToHead1(listNode, result);
        return result;
    }

    public void printListFromTailToHead1(ListNode listNode, ArrayList<Integer> result) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHead1(listNode.next,result);
        result.add(listNode.val);
    }
}
