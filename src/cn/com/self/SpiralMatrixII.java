package cn.com.self;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 2019.6.11 zx
 * 与SpiralMatrix相似，比原版还简单点，只需要向矩阵输入数字就行，一样换方向
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        SpiralMatrixII tmp = new SpiralMatrixII();
        int[][] res = tmp.generateMatrix(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int d = 0;

        int offset = 0, coloffset = 0;
        for(int i = 1; i <= n * n; i++){
            res[row][col] = i;

            row += dir[d][0];
            col += dir[d][1];

            //turn down
            if(col >= n -coloffset){
                col--;
                d = (d + 1) % 4;
                row++;
                continue;
            }

            //turn left
            if(row >= n - offset){
                row--;
                d = (d + 1) % 4;
                col--;
                continue;
            }

            //turn up
            if(col < 0 + coloffset){
                col = 0 + coloffset;
                d = (d + 1) % 4;
                offset++;
                row--;
                continue;
            }

            //turn right
            if(row < 0 + offset){
                row = 0 + offset;
                d = (d + 1) % 4;
                coloffset++;
                col++;
                continue;
            }
        }
        return res;
    }
}
