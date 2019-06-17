package cn.com.self;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * 2019.6.17 zx
 * 以下是discussion中的答案解释，此题为一道DP（dynamic programming 动态规划问题）需要注意！
 * Here is my understanding of the code: Array dp stores the number of paths which passing this point.
 *      The whole algorithm is to sum up the paths from left grid and up grid.
 *      'if (row[j] == 1) dp[j] = 0; means if there is an obstacle at this point.
 *      All the paths passing this point will no longer valid. In other words
 *      the grid right of the obstacle can be reached only by the grid which lies up to it.
 *      Hope it helps.
 * 大概意思：算法是计算，每一格上所有可以从左侧和上侧来的路径数量，但是当这一格上有障碍（该格值为1）时，那么所有路径都不通，该格路径数量变为0
 */
public class UniquePathsII {
    public static void main(String[] args) {
        //int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{1}};
        UniquePathsII tmp = new UniquePathsII();
        System.out.println(tmp.uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
//    private int findPath(int[][] obstacleGrid, int[][] dir, int i, int j, int res){
//        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1
//                && obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] != 1){
//            res++;
//            return res;
//        }
//        for(int m = 0; m < 2; m++){
//            if(i < 0 || j < 0 || i > obstacleGrid.length - 1 || j > obstacleGrid[0].length - 1){
//                return res;
//            }
//            if(obstacleGrid[i][j] == 1){
//                continue;
//            }
//            obstacleGrid[i][j] = 1;
//            i += dir[m][0];
//            j += dir[m][1];
//            res = findPath(obstacleGrid, dir, i, j, res);
//            i -= dir[m][0];
//            j -= dir[m][1];
//            obstacleGrid[i][j] = 0;
//        }
//        return res;
//    }
}
