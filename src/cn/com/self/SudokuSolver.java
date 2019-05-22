package cn.com.self;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * 2019.5.22 zx
 * DFS求数独
 * 具体可以看 https://www.jianshu.com/p/261c1fa91f38
 * Hard难度，啧
 * 好题目
 */

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver tmp = new SudokuSolver();
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }};
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        tmp.solveSudoku(board);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        DFS(board, 0);
    }
    private boolean DFS(char[][] board, int num){
        if(num == 81) return true;
        int i = num / 9, j = num % 9;
        if(board[i][j] != '.') return DFS(board, num + 1);

        boolean[] flag = new boolean[10];
        valid(board, i, j, flag);
        for(int k = 1; k <= 9; k++){
            if(flag[k]){
                board[i][j] = (char)(k + '0');
                if(DFS(board, num + 1)) return true;
            }
        }
        board[i][j] = '.';
        return false;
    }
    private void valid(char[][] board, int i, int j, boolean[] flag){
        Arrays.fill(flag, true);
        for(int k = 0; k < 9; k++){
            if(board[i][k] != '.') flag[board[i][k] - '0'] = false;  //一行内已经存在的数字
            if(board[k][j] != '.') flag[board[k][j] - '0'] = false;  //一列内已经存在的数字
            int r = i / 3 * 3 + k / 3; //一个3x3方格内已经存在数字
            int c = j / 3 * 3 + k % 3;
            if(board[r][c] != '.') flag[board[r][c] - '0'] = false;
        }
    }
}
