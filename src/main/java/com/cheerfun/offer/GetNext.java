package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname GetNext
 *  * @Author fangzhou
 *  * @Date 2020/5/5 3:21 下午
 *  * @Version V1.0
 *  
 */
public class GetNext {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            TreeLinkNode pRoot = pNode.next;
            if(pRoot.left == pNode) {
                return pRoot;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
