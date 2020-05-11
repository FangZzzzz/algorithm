package com.cheerfun.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *  * @Description TODO
 *  * @Classname ReConstructBinaryTree4
 *  * @Author fangzhou
 *  * @Date 2020/4/28 8:48 下午
 *  * @Version V1.0
 *  
 */
public class ReConstructBinaryTree4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>(pre.length);
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return preIn(pre, in, 0, pre.length - 1, 0, in.length - 1, inMap);
    }

    private TreeNode preIn(int[] pre, int[] in, int preI, int preJ, int inI, int inJ, Map<Integer, Integer> inMap) {
        if (preI > preJ) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preI]);
        int rootInI = inMap.get(pre[preI]);
        root.left = preIn(pre, in, preI + 1, preI + rootInI - inI, inI, rootInI - 1, inMap);
        root.right = preIn(pre, in, preI + rootInI - inI + 1, preJ, rootInI + 1, inJ, inMap);
        return root;
    }
}
