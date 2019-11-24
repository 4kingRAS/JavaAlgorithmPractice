package com.kkkk.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2019/11/22
 * @description s
 */
//TODO:

public class P4_FindMidNum {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            int[] num = nums1 == null ? nums2 : nums1;
            if (num.length % 2 == 0) {
                int mid = num.length / 2;
                return (num[mid - 1] + num[mid]) / 2f;
            } else {
                int mid = num.length / 2;
                return num[mid];
            }
        }



        return 0.0;
    }

    public static void main(String[] args) {
        int[] n1 = {-2, -1, 0, 1, 3, 5, 13};
        int[] n2 = {-25, 2, 4, 6, 11, 13};
        System.out.println(findMedianSortedArrays(n1, null));
    }
}
