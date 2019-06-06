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
 *
 * 2019.6.6 zx
 * 一开始想用递归，时间复杂度不够
 * discussion算法：far代表能够到达的最远距离，max代表当前能够到达的最远距离
 * 举个例子nums = [3,2,1,0,4]：
 *      第一步：begin为nums[0]，初始far为0，那么当前可以达到的最远距离为 下标+值 即：0 + 3 = 3,可以达到下标为3的位置
 *      第二步：如果max小于或等于far，而此时far小于最大的下标，说明永远无法到达最远距离，即无法到达终点，输出false，否则继续
 *      第三步：begin = far + 1, far = max，替换开始下标和最远距离
 *      第四步：begin为nums[1]，far为3,那么当前可以达到的最远距离为 3, max = 3 与 far 相等，输出false
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame tmp = new JumpGame();
        System.out.println(tmp.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int begin = 0, far = 0;
        int max = 0;

        while(far < nums.length - 1){
            for(int i = begin ; i <= far; i++){
                max = max > (i + nums[i]) ? max : (i + nums[i]);
            }
            if(max <= far){
                return false;
            }
            begin = far + 1;
            far = max;
        }

        return true;
    }

    /* 递归时间复杂度不够
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
    */
}
