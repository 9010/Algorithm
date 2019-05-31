package cn.com.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates
 * return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [ [1,1,2], [1,2,1], [2,1,1] ]
 *
 * 2019.5.31 zx
 * BackList解类似方法，还是递归，对每一个数，检查是否被用过，以及是否与前一个数相同，并且前一位数字没有被使用过
 * 本题必须先对nums数列进行排序！
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        PermutationsII tmp = new PermutationsII();
        System.out.println(tmp.permuteUnique(nums));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  //注意，必须先排序！！
        boolean[] used = new boolean[nums.length];
        BackList(result, new ArrayList<>(), nums, used);
        return result;
    }
    private void BackList(List<List<Integer>> result, List<Integer> templist, int[] nums, boolean[] used){
        if(templist.size() == nums.length){
            result.add(new ArrayList<>(templist));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
                templist.add(nums[i]);
                used[i] = true;
                BackList(result, templist, nums, used);
                templist.remove(templist.size() - 1);
                used[i] = false;
            }
        }
    }
}
