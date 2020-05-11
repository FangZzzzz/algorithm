package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname EntryNodeOfLoop
 *  * @Author fangzhou
 *  * @Date 2020/5/5 2:22 下午
 *  * @Version V1.0
 *  
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        fast = pHead;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
