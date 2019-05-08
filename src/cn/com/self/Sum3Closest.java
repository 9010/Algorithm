package cn.com.self;

/**
 * Given an array nums of n integers and an integer target
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * 也可以用Sum3类似的算法，这里用了时间复杂度O(n3) --n的3次方 的算法，写起来比较简单
 *
 * 2019.5.8 zx
 *
 */

public class Sum3Closest{
    public static void main(String[] args) {
        Sum3Closest tmp = new Sum3Closest();
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        System.out.println(tmp.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        int result = nums[0] + nums[1] + nums[2];
        int x, y, z;

        for(x = 0; x < nums.length - 2; x++){
            for(y = x + 1; y < nums.length - 1; y++){
                for(z = y + 1; z < nums.length; z++){
                    if (min > Math.abs(target - (nums[x] + nums[y] + nums[z]))){
                        min = Math.abs(target - (nums[x] + nums[y] + nums[z]));
                        result = nums[x] + nums[y] + nums[z];
                    }
                }
            }
        }

        return result;
    }
}
