package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns)
 * return all elements of the matrix in spiral(螺旋) order.
 *
 * 2019.6.5 zx
 * 未解出，但基本思想相同，核心是输出一列或者一行，然后换方向，一共四个方向，当第三次换方向的时候
 * 需要将下一次输出的列数字数量-1，第四次时将下一次说出的行的数字数量-1
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix tmp = new SpiralMatrix();
        System.out.println(tmp.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int d = 0;

        int offset = 0, coloffset = 0;
        for(int i = 0; i < matrix.length * matrix[0].length; i++){
            result.add(matrix[row][col]);

            row += dir[d][0];
            col += dir[d][1];

            //go right, and reach the end
            if(col >= matrix[0].length - coloffset){
                col--;
                d = (d + 1) % 4;
                row++;
                continue;
            }

            //go down, and reach the end
            if(row >= matrix.length - offset){
                row--;
                d = (d + 1) % 4;
                col--;
                continue;
            }

            //go left, and reach the end, and next travel will be one cell shorter(up and down direction)
            if(col < 0 + coloffset){
                col = 0 + coloffset;
                d = (d + 1) % 4;
                offset++;
                row--;
                continue;
            }

            //go up, and reach the end, and next travel will be one cell shorter(right and left direction)
            if(row < 0 + offset){
                row = 0 + offset;
                d = (d + 1) % 4;
                coloffset++;
                col++;
                continue;
            }
        }

        return result;
    }

}
