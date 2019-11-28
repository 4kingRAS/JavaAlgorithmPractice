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
            int mid = num.length >> 1;
            return (num.length % 2 == 0) ? (num[mid - 1] + num[mid]) / 2f : num[mid];
        }
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1); // 确保nums1 不长于 nums2。
        }
        int lo = 0, hi = len1;
        boolean isEven = (len1 + len2) % 2 == 0;
        while (lo <= hi) {
            int m1 = (lo + hi) >> 1; // 确保 m1 + m2 = len1+len2 - m1 - m2
            int m2 = ((len1 + len2 + 1) / 2) - m1;
            if (m1 != 0 && m2 != len2 && (nums1[m1 - 1] > nums2[m2])) {
                hi = m1 - 1;
            } else if (m1 != len1 && m2 != 0 && (nums1[m1] < nums2[m2 - 1])) {
                lo = m1 + 1;
            } else {
                int left = Math.max(nums1[m1 - 1], nums2[m2 - 1]);
                if (!isEven) return left;
                int right = Math.min(nums1[m1], nums2[m2]);
                return (left + right) / 2f;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] n1 = {-2, -1, 0, 1, 7, 5, 13};
        int[] n2 = {-25, 2, 4, 6, 11, 13};
        int[] n3 = {3};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
