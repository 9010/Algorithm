package cn.com.self;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 2019.6.27 zx
 * 空间复杂度必须为O(1)比较困难，两次循环
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,2,2,2,3,3,3,3,3};
        RemoveDuplicatesfromSortedArrayII tmp = new RemoveDuplicatesfromSortedArrayII();
        int n = tmp.removeDuplicates(nums);

        System.out.println(n);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();

        for(int i = 0; i < n; i++){
            System.out.print(nums[i]);
        }
        System.out.println();

    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 0;
        int startIndex = 0;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            }
            else if(nums[i] > nums[i - 1]){
                count = 0;
            }
            if(count == 2){
                startIndex = i;
                break;
            }
            res++;
        }
        System.out.println(startIndex);
        if(startIndex == 0 || startIndex == nums.length - 1) return res;

        for(int i = startIndex + 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                nums[startIndex] = nums[i];
                startIndex++;
                res++;
                count = 0;
            }
            else if(nums[i] == nums[i - 1] && count < 1){
                nums[startIndex] = nums[i];
                startIndex++;
                res++;
                count++;
            }
        }

        return res;
    }
}
