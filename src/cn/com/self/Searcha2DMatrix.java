package cn.com.self;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. .
 *
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * 2019.6.26 zx
 * 两次二分查找
 * 注意二分查找的结束条件，以及mid的算法，mid = (high - low) / 2 + low;
 */
public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 12, 16, 20}, {23, 30, 34, 50}};
//        int[][] matrix = {{1, 2}};
        int target = 10;
        Searcha2DMatrix tmp = new Searcha2DMatrix();
        System.out.println(tmp.searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        if(target > matrix[m - 1][n - 1] || target < matrix[0][0]) return false;
        int low = 0, high = m - 1;
        int midCol = (high - low) / 2 + low;
        while(low <= high){
            if(matrix[midCol][n - 1] > target){
                high = midCol - 1;
                midCol = (high - low) / 2 + low;
            }
            else if(matrix[midCol][n - 1] < target){
                low = midCol + 1;
                midCol = (high - low) / 2 + low;
            }
            else if(matrix[midCol][n - 1] == target){
                return true;
            }
        }
        System.out.println(midCol);
        low = 0;
        high = n - 1;
        int midRow = (high - low) / 2 + low;
        while(low <= high){
            if(matrix[midCol][midRow] > target){
                high = midRow - 1;
                midRow = (high - low) / 2 + low;
            }
            else if(matrix[midCol][midRow] < target){
                low = midRow + 1;
                midRow = (high - low) / 2 + low;
            }
            else if(matrix[midCol][midRow] == target){
                return true;
            }
        }
        return false;
    }
}
