package com.kkkk.codegame.tc;

/**
 * @author Yulin.Wang
 * @date 2019/9/15
 * @description s
 */
//TODO:

public class VIP1 {

    static int treeMax = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static int findTreeDiameter(TreeNode root) {
        treeMax = 0;
        if (root == null) { return 0; }
        if (root.left == null && root.right == null) { return 0; }
        getLength(root);
        return treeMax;
    }

    static int getLength(TreeNode n) {
        if (n != null) {
            int l = getLength(n.left);
            int r = getLength(n.right);
            treeMax = Math.max(treeMax, l + r);
            return Math.max(l, r) + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.right.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        root.right = new TreeNode(3);

        System.out.println(findTreeDiameter(root));
    }

}
