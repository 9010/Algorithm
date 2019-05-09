package cn.com.self;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
 * such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * 2019.5.9 zx
 * Sum3 + Sum3Closest 组合
 */

public class Sum4 {
    public static void main(String[] args) {
        Sum4 tmp = new Sum4();
        int[] nums = {1, 0 ,-1, 0, -2, 2};
        int target = 0;
        System.out.println(tmp.fourSum(nums, target).toString());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2 ; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                for (int j = i + 1; j < nums.length - 1; j++){
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int low = j + 1, height = nums.length - 1, sum = target - nums[i] - nums[j];
                        while (low < height) {
                            if (nums[low] + nums[height] == sum) {
                                result.add(Arrays.asList(nums[i], nums[low], nums[j], nums[height]));
                                while (low < height && nums[low] == nums[low + 1]) low++;
                                while (low < height && nums[height] == nums[height - 1]) height--;
                                low++;
                                height--;
                            } else if (nums[low] + nums[height] < sum) {
                                low++;
                            } else {
                                height--;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
