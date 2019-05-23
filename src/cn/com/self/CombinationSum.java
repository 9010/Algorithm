package cn.com.self;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target)
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *
 * 2019.5.23 zx
 * 递归计算
 * 大概算法：设一个数列，将candidate中的数一个个放进去，放一个数就计算target减去这个数剩下的值
 * “注意数字可以重复！！”
 * 当剩下的值小于0时，错误，当等于0时，就是正确解，存入result中，并在下次计算时将这个数跳过
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum tmp = new CombinationSum();
        System.out.println(tmp.combinationSum(candidates, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                tempList.add(nums[i]);
                BackList(result, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
