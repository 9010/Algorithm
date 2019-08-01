package cn.com.self;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums
 * return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * 2019.8.1 zx
 * 递归取字串，从长度为1开始，直到nums的长度
 */
public class SubsetsII {
    public static void main(String[] args) {
        int [] nums = {3,2,4,1};
        SubsetsII tmp = new SubsetsII();
        System.out.println(tmp.subsetsWithDup(nums).toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums.length == 0) return result;
        List<Integer> tmp = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++){
            Set<List<Integer>> resultTmp = new HashSet<>();
            resultTmp = findSubsets(resultTmp, tmp, i, 0, nums);
            result.addAll(resultTmp);
        }

        return result;
    }

    private Set<List<Integer>> findSubsets(Set<List<Integer>> resultTmp, List<Integer> tmp, int n, int index, int[] nums){
        if(tmp.size() == n){
            resultTmp.add(new ArrayList<>(tmp));
            return resultTmp;
        }
        for(int i = index; i < nums.length; i++){
            tmp.add(nums[i]);
            resultTmp = findSubsets(resultTmp, tmp, n, i + 1, nums);
            if(tmp.size() > 0) tmp.remove(tmp.size() - 1);
        }
        return resultTmp;
    }
}
