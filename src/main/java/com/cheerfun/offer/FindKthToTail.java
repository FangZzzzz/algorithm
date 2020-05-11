package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname FindKthToTail
 *  * @Author fangzhou
 *  * @Date 2020/4/29 8:42 下午
 *  * @Version V1.0
 *  
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode quickNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < k ; i++) {
            quickNode = quickNode.next;
        }
        while(quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
