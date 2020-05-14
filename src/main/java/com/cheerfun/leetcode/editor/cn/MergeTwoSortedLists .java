//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.cheerfun.leetcode.editor.cn;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
//leetcode submit region end(Prohibit modification and deletion)

}