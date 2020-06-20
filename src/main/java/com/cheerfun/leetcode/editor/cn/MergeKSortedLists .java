//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

package com.cheerfun.leetcode.editor.cn;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return mergeSort(lists, 0, lists.length - 1);
        }

        public ListNode mergeSort(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = l + (r - l) / 2;
            return mergeTwoLists(mergeSort(lists, l, mid), mergeSort(lists, mid + 1, r));
        }

        private ListNode mergeTwoLists(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return headA == null ? headB : headA;
            }
            ListNode head = new ListNode(-1);
            ListNode result = head;
            while (headA != null && headB != null) {
                if (headA.val > headB.val) {
                    head.next = headB;
                    headB = headB.next;
                } else {
                    head.next = headA;
                    headA = headA.next;
                }
                head = head.next;
            }
            head.next = headA == null ? headB : headA;
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}