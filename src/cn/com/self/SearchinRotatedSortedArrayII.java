package cn.com.self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * 2019.6.28 zx
 *    There are 2 sorted sub-arrays in nums and every number is a part of atleast one of them
 *    which means nums[mid] is a part of one such sorted sub-array. So, nums[high] <= nums[mid] or
 *    nums[mid] <= nums[low] or both, imply that nums[mid] is equal to atleast one of nums[high] and nums[low].
 *    Case 1: nums[mid] is a part of an increasing sub-array starting at index low and ending before high
 * 		   Since this sub-array is sorted, nums[low] >= nums[mid], where low <= mid implies that
 * 		   all the numbers at indices in range [low, mid] are equal.
 * 		   So in order to perform binary-search, we need to shrink this sorted sub-array until
 * 		   nums[low] != nums[mid]. Once this condition is satisfied we can perform binary search on the
 * 		   remaining sorted sub-array.
 * 		   Similarly for cases 2 and 3.
 *    Case 2: nums[mid] is a part of an increasing sub-array starting after index start and ending at high
 *    Case 3: nums[mid] is a part of an increasing sub-array starting at index low and ending at high
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1};
        int target = 3;
        SearchinRotatedSortedArrayII tmp = new SearchinRotatedSortedArrayII();
        System.out.println(tmp.search(nums, target));
    }
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[high]) { // failure means nums[mid] >= nums[high]
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else if (nums[mid] > nums[low]) { // failure means nums[mid] <= nums[low]
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] == nums[low]) {
                low++;
            } else if (nums[mid] == nums[high]) {
                high--;
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        if (nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        int mid = (high - low) / 2 + low;
        while (low < high) {
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else if(nums[mid] < nums[high]){
                high = mid;
            }
            else if (nums[mid] == nums[low]){
                low++;
            }
            else if(nums[mid] == nums[high]){
                high--;
            }
            mid = (high - low) / 2 + low;
        }
        System.out.println(mid);
        if (target == nums[mid]) return true;
        else if (target < nums[mid]) return false;
        else if (mid == 0) {
            low = 0;
            high = nums.length - 1;
            mid = (high - low) / 2 + low;
            while (low <= high) {
                if (target > nums[mid]) {
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                } else {
                    return true;
                }
            }
        } else if (target <= nums[mid - 1] && target > nums[nums.length - 1]) {
            low = 0;
            high = mid - 1;
            mid = (high - low) / 2 + low;
            while (low <= high) {
                if (target > nums[mid]) {
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                } else {
                    return true;
                }
            }
        } else if (target < nums[nums.length - 1]) {
            low = mid;
            high = nums.length - 1;
            mid = (high - low) / 2 + low;
            while (low <= high) {
                if (target > nums[mid]) {
                    low = mid + 1;
                    mid = (high - low) / 2 + low;
                } else if (target < nums[mid]) {
                    high = mid - 1;
                    mid = (high - low) / 2 + low;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
