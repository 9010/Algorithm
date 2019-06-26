package cn.com.self;

/**
 * Given an array with n objects colored red, white or blue
 * sort them in-place so that objects of the same color are adjacent
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * 2019.6.26 zx
 * 含有重复数字的排序，不复杂
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors tmp = new SortColors();
        tmp.sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++){
            switch (nums[i]){
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }

        int index = 0;
        while(num0 != 0){
            nums[index] = 0;
            index++;
            num0--;
        }
        while(num1 != 0){
            nums[index] = 1;
            index++;
            num1--;
        }
        while(num2 != 0){
            nums[index] = 2;
            index++;
            num2--;
        }
    }
}
