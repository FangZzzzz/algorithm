//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

package com.cheerfun.leetcode.editor.cn;

class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode before = new ListNode(-1);
            ListNode after = new ListNode(-1);
            ListNode curBefore = before;
            ListNode curAfter = after;
            while(head != null) {
                if(head.val < x) {
                    curBefore.next = head;
                    curBefore = curBefore.next;
                } else {
                    curAfter.next = head;
                    curAfter = curAfter.next;
                }
                ListNode temp = head.next;
                head.next = null;
                head = temp;
            }
            curBefore.next = after.next;
            return before.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}