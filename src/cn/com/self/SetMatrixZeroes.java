package cn.com.self;

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
        int[][] matrix = {{1, 1, 2, 0}, {0, 4, 5, 2}, {1, 3, 1, 5}};
        //int[][] matrix = {{1}, {0}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        SetMatrixZeroes tmp = new SetMatrixZeroes();
        tmp.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if(matrix ==null||matrix.length ==0){
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        if(n == 0){
            return;
        }

        boolean firstColZero = false;
        for(int i = 0; i < m; i++){
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0]==0){
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstColZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
    public void setZeroes3(int[][] matrix) {
        if(matrix.length == 0) return;
        boolean setFirstColZero = false;
        boolean setFirstRowZero = false;

        if(matrix[0][0] == 0){
            setFirstColZero = true;
            setFirstRowZero = true;
        }
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(row == 0 && matrix[row][col] == 0){
                    setFirstColZero = true;
                }
                if( col == 0 && matrix[row][col] == 0){
                    setFirstRowZero = true;
                }
                else if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        System.out.println(setFirstColZero + "  " + setFirstRowZero);

        //set Zero
        for(int row = 1; row < matrix.length; row++){
            if(matrix[row][0] == 0){
                for(int col = 1; col < matrix[0].length; col++){
                    matrix[row][col] = 0;
                }
            }
        }
        for(int col = 1; col < matrix[0].length; col++){
            if(matrix[0][col] == 0){
                for(int row = 1; row < matrix.length; row++){
                    matrix[row][col] = 0;
                }
            }
        }

        if(setFirstColZero){
            for(int col = 0; col < matrix[0].length; col++){
                matrix[0][col] = 0;
            }
        }
        if(setFirstRowZero){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;
            }
        }
    }
    public void setZeroes2(int[][] matrix) {
        if(matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] line = new int[row];
        int[] list = new int[col];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    line[i] = 1;
                    list[j] = 1;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(line[i] == 1 || list[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
