package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2020/8/28
 * @description
 *
 * 递归法oN^2 和 插入法，插入法遇到降序多的数组会劣化为On^2
 */

public class P654_MaxBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode makeMaximumBinaryTree(int[] nums) {

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > root.val) {
                TreeNode tmp = new TreeNode(nums[i]);
                tmp.left = root;
                root = tmp;
            } else {
                TreeNode tmp = root;
                while (tmp.right != null) {
                    if (nums[i] > tmp.right.val) {
                        TreeNode t = tmp.right;
                        tmp.right = new TreeNode(nums[i]);
                        tmp.right.left = t;
                        break;
                    } else {
                        tmp = tmp.right;
                    }
                }
                if (tmp.right == null) {
                    tmp.right = new TreeNode(nums[i]);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 1, 6, 0, 5};
        TreeNode r = makeMaximumBinaryTree(n);
        System.out.println("2");
    }

}
