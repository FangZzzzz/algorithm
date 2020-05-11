package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname Merge
 *  * @Author fangzhou
 *  * @Date 2020/4/30 6:57 下午
 *  * @Version V1.0
 *  
 */
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            ListNode temp = null;
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        return head.next;
    }
}
