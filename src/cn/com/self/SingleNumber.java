package cn.com.self;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * 2019.9.19 zx
 * 求一组数列，其中只有一个数字出现一次，其他均出现两次
 * 对整个数列依次求异或，最后得出的结果就是单独出现的数字
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        SingleNumber tmp = new SingleNumber();
        System.out.println(tmp.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
