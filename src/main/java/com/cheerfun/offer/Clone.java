package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname Clone
 *  * @Author fangzhou
 *  * @Date 2020/5/2 3:20 下午
 *  * @Version V1.0
 *  
 */
public class Clone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 在原链表后每个结点后加一个复制结点，不拷贝random指针
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode copyCur = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = copyCur;
            copyCur.next = next;
            cur = next;
        }
        // 拷贝random指针
        cur = pHead;
        while (cur != null) {
            RandomListNode randomCur = cur.random;
            if (cur.random != null) {
                cur.next.random = randomCur.next;
            }
            cur = cur.next.next;
        }
        // 拆分原链表和新链表
        cur = pHead;
        RandomListNode result = pHead.next;
        while (cur != null) {
            RandomListNode copyCur = cur.next;
            // 当前不为null，下一个肯定不为null
            cur.next = cur.next.next;
            if (copyCur.next != null) {
                copyCur.next = copyCur.next.next;
            }
            cur = cur.next;
        }
        return result;
    }
}
