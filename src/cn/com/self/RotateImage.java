package cn.com.self;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place
 * which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * 2019.5.31 zx
 * 没什么算法，几乎可以说是凑出来的
 * 但是时间和空间复杂度都很低
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11},{2, 4, 8, 10}, {13, 3, 6, 7},{15, 14, 12, 16}};
        RotateImage tmp = new RotateImage();
        tmp.rotate(matrix);
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;

        for(int i = 0; i < (matrix.length) / 2; i++) {
            for (int j = i, k = matrix.length - 1 - i * 2; j < matrix.length - 1 - i; j++, k--) {
                int tmp1, tmp2;

                int m = i, n = j;
                int cm = m + (matrix.length - 1 - i * 2 - k), cn = n + k; //第1次
                tmp1 = matrix[cm][cn];
                matrix[cm][cn] = matrix[m][n];

                m = cm;
                n = cn;
                cm = m + k;
                cn = n - (matrix.length - 1 - i * 2 - k);  //第2次
                tmp2 = matrix[cm][cn];
                matrix[cm][cn] = tmp1;

                m = cm;
                n = cn;
                cm = m - (matrix.length - 1 - i * 2 - k);
                cn = n - k; //第3次
                tmp1 = matrix[cm][cn];
                matrix[cm][cn] = tmp2;

                m = cm;
                n = cn;
                cm = m - k;
                cn = n + (matrix.length - 1 - i * 2 - k); //第4次
                matrix[cm][cn] = tmp1;

            }
        }
    }

//    private void swap(int[][] matrix, int i, int j, int m, int n){
//        int tmp = matrix[i][j];
//        matrix[i][j] = matrix[m][n];
//        matrix[m][n] = tmp;
//    }
}
