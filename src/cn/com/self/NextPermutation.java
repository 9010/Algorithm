package cn.com.self;

import java.util.Arrays;

/**
 * Implement next permutation
 * which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible
 * it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation tmp = new NextPermutation();
        int[] nums = {1, 2, 3};
        tmp.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "-");
        }
    }

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<2)
            return;
        int index=n-1;
        while(index>0){
            if(nums[index-1]<nums[index])
                break;
            index--;
        }
        if(index==0){
            reverseSort(nums,0,n-1);
            return;
        }
        else{
            int val=nums[index-1];
            int j=n-1;
            while(j>=index){
                if(nums[j]>val)
                    break;
                j--;
            }
            swap(nums,j,index-1);
            reverseSort(nums,index,n-1);
            return;
        }
    }

    public void swap(int[] num, int i, int j){
        int temp=0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public void reverseSort(int[] num, int start, int end){
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(num,i,start+end-i);
    }
}
