package cn.com.self;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * 2019.5.23 zx
 * leetCode上的答案，时间复杂度O(n)，空间复杂度O(1)
 * 大概思想：将每一个小于数组长度的数，放在他应该在的位置上。
 * 例如：数组长度为5，那么1，2，3，4，5就应该分别在下标为：0，1，2，3，4的位置上
 * 大于数组长度的数不考虑，因为最小的正整数必定在数组长度中，否则就是数组长度+1，或者1
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        FirstMissingPositive tmp = new FirstMissingPositive();
        System.out.println(tmp.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        for(int j = 0; j < A.length; j++){
            System.out.print(A[j] + " ");
        }
        System.out.println();
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
