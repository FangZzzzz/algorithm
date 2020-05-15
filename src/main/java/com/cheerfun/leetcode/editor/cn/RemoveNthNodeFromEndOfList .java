//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

package com.cheerfun.leetcode.editor.cn;

class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || n == 0) {
                return head;
            }
            if (head.next == null && n == 1) {
                return null;
            }
            ListNode fast = head;
            for (int i = 1; i < n; i++) {
                fast = fast.next;
            }
            ListNode slow = head;
            ListNode pre = null;
            while (fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
            }
            if(pre == null) {
                return head.next;
            }
            pre.next = slow.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}