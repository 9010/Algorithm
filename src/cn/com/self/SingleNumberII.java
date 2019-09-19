package cn.com.self;

/**
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Explain:
 * The usual bit manipulation code is bit hard to get and replicate.
 * I like to think about the number in 32 bits and just count how many 1s are there in each bit,
 * and sum %= 3 will clear it once it reaches 3.
 * After running for all the numbers for each bit,
 * if we have a 1, then that 1 belongs to the single number,
 * we can simply move it back to its spot by doing ans |= sum << i;
 *
 * This has complexity of O(32n), which is essentially O(n) and very easy to think and implement.
 * Plus, you get a general solution for any times of occurrence.
 * Say all the numbers have 5 times, just do sum %= 5.
 *
 * 2019.9.19 zx
 * 一个int数据32位，对于每一位，计算有几个1，如果是3的整数倍，那么单独的数字在这一位就是0，否则是1
 * 对于类似的任意次数重复，比如重复5次，那么就是5的整数倍
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};

        SingleNumberII tmp = new SingleNumberII();
        System.out.println(tmp.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }
}
