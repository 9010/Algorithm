package cn.com.self;


/**
 * Given an array nums and a value val
 * remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 *
 * 2019.5.13 zx
 * 细节一大堆。。。
 * 例如：nums[] = {2, 2} val = 2;
 *      nums[] = {2} val = 2;
 *      nums[] = {2, 2} val = 1;
 *      等
 * 算法不难
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement tmp = new RemoveElement();
        int val = 3;
        int[] nums = {3, 2};
        int len = tmp.removeElement(nums, val);
        for (int i = 0; i < len; i++){
            System.out.print(nums[i]+"  ");
        }
    }
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int hight = nums.length - 1;

        if(low == hight && nums[low] != val) return 1;

        while(low <= hight){
            if(nums[low] == val){
                while(nums[hight] == val && low < hight){
                    hight--;
                }
                if(low < hight) {
                    nums[low] = nums[hight];
                    nums[hight] = val;
                    low++;
                }
                else {
                    break;
                }
            }
            else {
                low++;
            }
        }
        return low;
    }
}
