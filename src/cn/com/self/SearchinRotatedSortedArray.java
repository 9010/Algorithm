package cn.com.self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * 2019.5.15 zx
 * Discuss的答案：
 *      int realmid = (mid + rotate) % nums.length;
 * 可以直接找到正常排序的正中间，然后利用二分查找就行
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray tmp = new SearchinRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(tmp.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if(target > nums[high] && target < nums[low]){
            return -1;
        }
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        int rotate = low;
        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int realmid = (mid + rotate) % nums.length; //可以找到顺序排序的正中间（对应普通二分查找）
            if(nums[realmid] == target) return realmid;
            if(nums[realmid] < target) low = mid + 1;
            else  high = mid - 1;
        }
        return -1;
    }
}
