package cn.com.self;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * 2019.6.12 zx
 * 一開始想用遞歸，但是時間複雜度不夠
 * 其實是排列組合問題，從左上角走到右下角，衹能向右或者向下移動，那麽縂步數：向右m-1步，向下n-1步
 * 對這兩個進行排列組合，結果共有 （m + n - 2)! / ( (m - 1)! * (n - 1)! )個
 * 但是直接計算階層時間複雜度也不夠，需要計算最簡單的數字，例：
 *      33! / (22! * 11!) 可化簡為: 33 * 32 * ...... * 23 / 11 * 10 * ...... * 1
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 23, n = 12;
        UniquePaths tmp = new UniquePaths();
        System.out.println(tmp.uniquePaths(m, n));
    }
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int right = m - 1;
        int down = n - 1;
        int total = right + down;

        long res = 1;
        for(int i = right + 1, j = 1; i <= total; i++, j++){
            res *= i;
            res /= j;
        }
//        int[][] grid = new int[n][m];
//        for(int i = 0; i < n; i++){
//            Arrays.fill(grid[i], 1);
//        }
//        int[][] dir = {{0, 1}, {1, 0}};
//        int res = path(grid, dir, 0, 0, 0);
        return (int)res;
    }

//    private int path(int[][] grid, int[][] dir, int i, int j, int res){
//        if(i == grid.length - 1 && j == grid[0].length - 1){
//            res++;
//            return res;
//        }
//        for(int m = 0; m < 2; m++){
//            if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
//                return res;
//            }
//            if(grid[i][j] == 0){
//                continue;
//            }
//            grid[i][j] = 0;
//            i += dir[m][0];
//            j += dir[m][1];
//            res = path(grid, dir, i, j, res);
//            i -= dir[m][0];
//            j -= dir[m][1];
//            grid[i][j] = 1;
//        }
//        return res;
//    }
}
