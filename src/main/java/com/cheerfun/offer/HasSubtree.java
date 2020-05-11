package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname HasSubtree
 *  * @Author fangzhou
 *  * @Date 2020/4/30 7:05 下午
 *  * @Version V1.0
 *  
 */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = hasSubtreePro(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;

    }

    public boolean hasSubtreePro(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return hasSubtreePro(root1.left, root2.left) && hasSubtreePro(root1.right, root2.right);
    }
}
