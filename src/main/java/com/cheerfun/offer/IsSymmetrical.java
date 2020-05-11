package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname IsSymmetrical
 *  * @Author fangzhou
 *  * @Date 2020/5/5 3:30 下午
 *  * @Version V1.0
 *  
 */
public class IsSymmetrical {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricalHelper(left.left, right.right) && isSymmetricalHelper(right.left, left.right);
    }
}
