//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写
//入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package com.cheerfun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class LruCache {
    public static void main(String[] args) {
        /*LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);*/
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head;
        ListNode tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            int result = -1;
            ListNode cur = null;
            if (map.containsKey(key)) {
                cur = map.get(key);
            }
            if (cur != null) {
                result = cur.val;
                removeNode(cur);
                addHeadNode(cur);
            }
            return result;
        }

        public void put(int key, int value) {
            ListNode cur = null;
            if (map.containsKey(key)) {
                cur = map.get(key);
            }
            if (cur != null) {
                cur.val = value;
                removeNode(cur);
                addHeadNode(cur);
                return;
            }
            if (map.size() == capacity) {
                ListNode listNode = removeLast();
                map.remove(listNode.key);
            }
            cur = new ListNode(key, value);
            addHeadNode(cur);
            map.put(key, cur);
        }

        private ListNode removeLast() {
            ListNode last = tail.pre;
            removeNode(last);
            return last;
        }

        private void removeNode(ListNode node) {
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        private void addHeadNode(ListNode node) {
            ListNode next = head.next;
            head.next = node;
            node.next = next;
            node.pre = head;
            next.pre = node;
        }

        class ListNode {
            int val;
            int key;
            ListNode pre;
            ListNode next;

            public ListNode() {
            }

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}