package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname FindFirstCommonNode
 *  * @Author fangzhou
 *  * @Date 2020/5/4 12:10 下午
 *  * @Version V1.0
 *  
 */
public class FindFirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(3);
        ListNode node4  = new ListNode(4);
        ListNode node5  = new ListNode(5);
        ListNode node6  = new ListNode(6);
        ListNode node7  = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;
        node5.next = node6;
        node6.next = node7;
        FindFirstCommonNode(node1,node5);
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int size1 = 0, size2 = 0;
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                size1++;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                size2++;
                cur2 = cur2.next;
            }
        }
        int differ = Math.abs(size1 - size2);
        cur1 = pHead1;
        cur2 = pHead2;
        if (size1 > size2) {
            while (differ > 0) {
                cur1 = cur1.next;
                differ--;
            }
        } else {
            while (differ > 0) {
                cur2 = cur1.next;
                differ--;
            }
        }

        while (cur1 != null) {
            if(cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
