package cn.com.self;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 *
 * 2019.7.1 zx
 * 拼接之后排序，不想想别的算法了，太蠢
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};
        int m = 6, n = 3;
        MergeSortedArray tmp = new MergeSortedArray();
        tmp.merge(nums1, m, nums2, n);
        for(int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums2.length == 0) return;
        for(int i = m, j = 0; i < nums1.length; i++, j++){
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
