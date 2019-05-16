package cn.com.self;

/**
 * Given an array of integers nums sorted in ascending order
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray tmp = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {1};
        int target = 1;
        int[] result = tmp.searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0)
            return result;

        result[0] = findStartPosition(nums, target);
        result[1] = findEndPosition(nums, target);

        return result;
    }

    public int findStartPosition(int[] a, int target){

        int left = 0;
        int right = a.length-1;
        int start =-1;

        while(left<= right){

            int mid = left+(right-left)/2;  //就是(left+right)/2....

            if (a[mid] == target){
                start = mid; // this is start
                right = mid-1; // lets see if there one more on the left
            }else if (target > a[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return start;
    }

    public int findEndPosition(int[] a, int target){
        int left = 0;
        int right = a.length-1;
        int end = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if (a[mid] == target){
                end = mid;	  // this is the end
                left = mid+1; // lets see if there is one more on the right
            }else if (target > a[mid])
                left = mid +1;
            else
                right = mid -1;

        }

        return end;
    }
}
