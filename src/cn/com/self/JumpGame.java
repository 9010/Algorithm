package cn.com.self;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame tmp = new JumpGame();
        System.out.println(tmp.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        boolean can = false;

        can = jump(nums, 0);

        return can;
    }

    private boolean jump(int[] nums, int index){
        if(index == nums.length - 1){
            return true;
        }
        else if (index >= nums.length){
            return false;
        }

        for(int i = nums[index]; i > 0; i--){
            if(jump(nums, index + i)){
                return true;
            }
        }

        return false;
    }
}
