package cn.com.self;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * 现将数组排序，然后对于数组中任意一个数字，找有没有两个数加起来等于它的负数，是则加入结构，注意有可能是多个
 * 对于重复：排序之后，先看这个数字与他之前的数字是否相同，相同则跳过
 *
 * 2019.5.8 zx
 */

public class Sum3 {
    public static void main(String[] args) {
        Sum3 tmp = new Sum3();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(tmp.threeSum(num).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){ //去掉重复数字，对于第一个数字不予理会
                int low = i + 1, height = nums.length - 1, sum = 0 - nums[i];
                while (low < height) {
                    if (nums[low] + nums[height] == sum) {
                        result.add(Arrays.asList(nums[low], nums[i], nums[height]));
                        while (low < height && nums[low] == nums[low + 1]) low++;
                        while (low < height && nums[height] == nums[height - 1]) height--;
                        low++;
                        height--;
                    }
                    else if (nums[low] + nums[height] < sum){
                        low++;
                    }
                    else{
                        height--;
                    }
                }
            }
        }

        return result;
    }
}
