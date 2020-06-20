//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package com.cheerfun.leetcode.editor.cn;

class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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

        private ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            // base case
            if (m == 1) {
                return reverseN(head, n);
            }
            // 前进到反转的起点触发 base case
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }

        private ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}