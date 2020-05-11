package com.cheerfun.offer;

import java.util.List;

/**
 *  * @Description TODO
 *  * @Classname DeleteDuplication
 *  * @Author fangzhou
 *  * @Date 2020/5/5 3:07 下午
 *  * @Version V1.0
 *  
 */
public class DeleteDuplication {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next  =node2;
        node2.next  =node3;
        node3.next  =node4;
        node4.next  =node5;
        node5.next  =node6;
        node6.next  =node7;
        deleteDuplication(node1);
    }


    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;
        ListNode preHead = new ListNode(0);
        preHead.next = pHead;
        ListNode pre = preHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return preHead.next;
    }
}
