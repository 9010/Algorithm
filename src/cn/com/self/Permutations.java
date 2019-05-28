package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * 2019.5.28 zx
 * 找所有解第一考虑：递归
 * BackList用于解类似问题，与CombinationSum类似
 * 举例：[1,2,3]
 *  将1存入数组，进入递归，从头开始读数组，输入1，发现已经存在，跳过，输入2，通过
 *  再进入递归，从头开始读数组，1,2被跳过，输入3成功，将数组[1,2,3]存入答案，回退一位变成[1,2]，再回退一位变为[1],
 *  顺位输入3成功，进入递归，1跳过，输入2成功，再重复回退
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations tmp = new Permutations();
        System.out.println(tmp.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        BackList(result, new ArrayList<>(), nums);
        return result;
    }
    private void BackList(List<List<Integer>> result, List<Integer> templist, int[] nums){
        if(templist.size() == nums.length){
            result.add(new ArrayList<>(templist));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if(templist.contains(nums[i])) continue;
                templist.add(nums[i]);
                BackList(result, templist, nums);
                templist.remove(templist.size() - 1);
            }
        }
    }
}
