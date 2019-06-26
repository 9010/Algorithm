package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * 2019.6.26 zx
 * 递归
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets tmp = new Subsets();
        System.out.println(tmp.subsets(nums).toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        res.add(new ArrayList<>());
        res = backList(res, tmp, nums, 0);

        return res;
    }
    private List<List<Integer>> backList(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            res = backList(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
        return res;
    }
}
