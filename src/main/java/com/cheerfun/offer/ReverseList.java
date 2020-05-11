package com.cheerfun.offer;

import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname ReverseList
 *  * @Author fangzhou
 *  * @Date 2020/4/29 8:53 下午
 *  * @Version V1.0
 *  
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            cur.next = pop;
            cur = pop;
        }
        cur.next = null;
        return head;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
