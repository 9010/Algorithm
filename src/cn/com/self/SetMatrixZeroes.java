package cn.com.self;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 *
 * 2019.6.25 zx
 * 时间复杂度O(m * n)，空间复杂度O(m + n)
 * 需要improve
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        SetMatrixZeroes tmp = new SetMatrixZeroes();
        tmp.setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        Set<Integer> line = new HashSet<>();
        Set<Integer> list = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    line.add(i);
                    list.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(line.contains(i) || list.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
