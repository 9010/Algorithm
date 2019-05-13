package cn.com.self;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 2019.5.13 zx
 * 要求空间复杂度为O(1)，只能在原数列上修改，不过还是easy难度
 */

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray tmp = new RemoveDuplicatesfromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(tmp.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+"  ");
        }
    }
    public int removeDuplicates(int[] nums) {
        int len = 1;
        boolean duplicates = false;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                duplicates = true;
            }
            else if(nums[i] < nums[i+1]){
                nums[len] = nums[i+1];
                duplicates =false;
                len++;
            }
        }
        return len;
    }
}
