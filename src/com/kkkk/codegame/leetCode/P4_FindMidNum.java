package com.kkkk.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2019/11/22
 * @description 思路比较简单，数轴划分，难点在实现划分和边界条件。
 */

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
            int m1 = (lo + hi) / 2; // 确保 m1 + m2 = len1+len2 - m1 - m2
            int m2 = ((len1 + len2 + 1) / 2) - m1;
            if (m1 != 0 && m2 != len2 && (nums1[m1 - 1] > nums2[m2])) { //1左大于2右，往左减半
                hi = m1 - 1;
            } else if (m1 != len1 && m2 != 0 && (nums1[m1] < nums2[m2 - 1])) { //1右小于2左，往右减半
                lo = m1 + 1;
            } else {
                int left = 0;
                if (m1 == 0) { left = nums2[m2 - 1]; }
                else if (m2 == 0) { left = nums1[m1 - 1]; }
                else { left = Math.max(nums1[m1 - 1], nums2[m2 - 1]); }
                if (!isEven) return left;

                int right = 0;
                if (m1 == len1) { right = nums2[m2]; }
                else if (m2 == len2) { right = nums1[m1]; }
                else { right = Math.min(nums1[m1], nums2[m2]); }
                return (left + right) / 2f;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] n1 = {-2, -1, 0};
        int[] n2 = {-25, 2, 4, 6, 11, 13};
        int[] n4 = {1,2};
        int[] n3 = {-1,3};
        System.out.println(findMedianSortedArrays(n4, n3));
    }
}
