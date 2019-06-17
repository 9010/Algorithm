package cn.com.self;

/**
 * Given a m x n grid filled with non-negative numbers
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * 2019.6.17 zx
 * dp问题，选择每一格上或者左相加起来最小的数字
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum tmp = new MinimumPathSum();
        System.out.println(tmp.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int high = grid.length;
        int width = grid[0].length;
        for(int i = 0; i < high; i++){
            for(int j = 0; j < width; j++){
                if(i > 0 && j > 0){
                    grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
                }
                else if(i > 0){
                    grid[i][j] += grid[i - 1][j];
                }
                else if(j > 0){
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[high - 1][width - 1];
    }
}
