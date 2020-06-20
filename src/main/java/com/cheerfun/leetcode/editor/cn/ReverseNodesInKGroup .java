//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package com.cheerfun.leetcode.editor.cn;

class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.reverseKGroup(node1, 2);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pHead = new ListNode(-1);
            ListNode result = pHead;
            pHead.next = head;

            int sum = 0;
            while (pHead.next != null) {
                // 当前前驱节点
                ListNode preHead = pHead;
                // 当前节点
                ListNode cur = pHead;
                while (cur != null) {
                    cur = cur.next;
                    sum++;
                    if (sum % k == 0) {
                        break;
                    }
                }
                if (cur != null) {
                    // 下一个节点头节点
                    ListNode nextHead = preHead.next;
                    ListNode temp = cur.next;
                    // 切断链表
                    cur.next = null;
                    preHead.next = reverseList(preHead.next);
                    pHead = nextHead;
                    nextHead.next = temp;
                } else {
                    break;
                }
            }
            return result.next;
        }

/*        private ListNode reverseList(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode root = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return root;
        }*/


        private ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}