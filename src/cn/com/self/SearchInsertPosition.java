package cn.com.self;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 * 2019.5.20 zx
 * 二分查找
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition tmp = new SearchInsertPosition();
        int[] nums = {1};
        int target = 0;
        System.out.println(tmp.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if(target > nums[high]){
            return high + 1;
        }
        else if(target < nums[low]){
            return 0;
        }
        int mid = (low + high) / 2;
        while(low < high){
            mid = (low + high) / 2;
            if(nums[mid] > target){
                high = mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] == target){
                return mid;
            }
        }
        if(nums[mid] > target){
            return mid;
        }
        else if(nums[mid] < target){
            return mid + 1;
        }
        return mid;
    }
}
