//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package com.cheerfun.leetcode.editor.cn;

class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.swapPairs(node1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode pHead = new ListNode(-1);
            pHead.next = head;
            ListNode cur = pHead;
            while (cur.next != null && cur.next.next != null) {
                swap(cur, cur.next, cur.next.next);
                cur = cur.next.next;
            }
            return pHead.next;
        }

        private void swap(ListNode pre, ListNode node1, ListNode node2) {
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}