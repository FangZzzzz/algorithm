//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package com.cheerfun.leetcode.editor.cn;

import java.util.Stack;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p = l1, q = l2;
            ListNode resultHead = new ListNode(0);
            ListNode cur = resultHead;
            int carry = 0;
            while (p != null || q != null || carry != 0) {
                int a = 0, b = 0;
                if (p != null) a = p.val;
                if (q != null) b = q.val;
                int sum = a + b + carry;
                ListNode newNode = new ListNode(sum % 10);
                carry = sum / 10;
                cur.next = newNode;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
                cur = cur.next;
            }
            return resultHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}