package cn.com.self;

/**
 * Given an integer array nums
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *  Input: [-2,1,-3,4,-1,2,1,-5,4],
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *  2019.6.5 zx
 *  easy难度的题目
 *  没想出来，根据别人的算法
 *  currmax和max的初值均为nums[0]，currmax加上接下来一个数的值与这个数本身比大小，大的胜出，存入currmax中
 *  currmax再于max比较，大的存入max
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int nums[] = {-1, -2};
        MaximumSubarray tmp = new MaximumSubarray();
        System.out.println(tmp.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int currmax, max;
        currmax = max = nums[0];

        for(int i = 1; i < nums.length; i++){
            currmax = Math.max(currmax + nums[i], nums[i]);
            max = Math.max(max, currmax);
        }

        return max;
    }
}
