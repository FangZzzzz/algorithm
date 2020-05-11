package com.cheerfun.offer;

import java.util.ArrayList;

/**
 *  * @Description TODO
 *  * @Classname FindPath
 *  * @Author fangzhou
 *  * @Date 2020/5/2 3:03 下午
 *  * @Version V1.0
 *  
 */
public class FindPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findResult(root, target, result, path);
        return result;
    }


    public void findResult(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (0 == target && root.left == null && root.right == null) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);
        }
        findResult(root.left, target, result, path);
        findResult(root.right, target, result, path);
        path.remove(path.size() - 1);
    }
}
