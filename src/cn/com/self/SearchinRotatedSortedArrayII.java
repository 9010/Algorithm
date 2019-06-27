package cn.com.self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 2, 2};
        int target = 0;
        SearchinRotatedSortedArrayII tmp = new SearchinRotatedSortedArrayII();
        System.out.println(tmp.search(nums, target));
    }
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        int mid = (high - low) / 2 + low;
        while(low < high){
            if(nums[mid] > nums[high]){
                low = mid + 1;
                mid = (high - low) / 2 + low;
            }
            else{
                high = mid;
                mid = (high - low) / 2 + low;
            }
        }
        System.out.println(mid);
        if(target == nums[mid]) return true;
        else if(target < nums[mid]) return false;
        else if(mid == 0){
            low = 0;
            high = nums.length - 1;
            mid = (high - low) / 2 + low;
            while(low <= high){
                if(target > nums[mid]){
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                }
                else{
                    return true;
                }
            }
        }
        else if(target <= nums[mid - 1] && target > nums[nums.length - 1]){
            low = 0;
            high = mid - 1;
            mid = (high - low) / 2 + low;
            while(low <= high){
                if(target > nums[mid]){
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                }
                else{
                    return true;
                }
            }
        }
        else if(target < nums[nums.length - 1]){
            low = mid;
            high = nums.length - 1;
            mid = (high - low) / 2 + low;
            while(low <= high){
                if(target > nums[mid]){
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}
