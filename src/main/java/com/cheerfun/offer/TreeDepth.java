package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname TreeDepth
 *  * @Author fangzhou
 *  * @Date 2020/5/4 12:43 下午
 *  * @Version V1.0
 *  
 */
public class TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }

}
