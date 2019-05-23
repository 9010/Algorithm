package cn.com.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target)
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 * 2019.5.22 zx
 * 要求数字不能重复，增加if(i > start && nums[i] == nums[i-1]) continue;
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII tmp = new CombinationSumII();
        System.out.println(tmp.combinationSum2(candidates, target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        BackList(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    private void BackList(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; //数字重复则跳过，适用于开头的数字
                tempList.add(nums[i]);
                BackList(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
