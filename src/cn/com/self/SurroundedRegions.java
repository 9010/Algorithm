package cn.com.self;

import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 * Surrounded regions shouldn’t be on the border
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * 2019.9.6 zx
 * 看是否有边界有O，如果有查看与其相连的所有O
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board ={{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        SurroundedRegions tmp = new SurroundedRegions();
        tmp.solve(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
        if(board.length == 0 || board.length == 1 || board[0].length == 1) return;
        int[][] change = new int[board.length][board[0].length];
        int[][] go = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0, j = 0;
        for(int k = 0; k < go.length;){
            if(board[i][j] == 'O'){
                change[i][j] = 1;
                searchO(board, i, j, change);
            }

            i = i + go[k][0];
            j = j + go[k][1];

            if(j + 1 == board[0].length && i == 0) k++;
            if(j + 1 == board[0].length && i + 1 == board.length) k++;
            if(j == 0 && i + 1 == board.length) k++;
            if(i == 0 && j == 0) k++;
        }

        for(int m = 0; m < board.length; m++){
            for(int n = 0; n < board[0].length; n++){
                if(change[m][n] == 0){
                    board[m][n] ='X';
                }
            }
        }
    }

    private void searchO(char[][] board, int i, int j, int[][] change){
        if(i + 1 < board.length){
            if(board[i + 1][j] == 'O' && change[i + 1][j] == 0){
                change[i + 1][j] = 1;
                searchO(board, i + 1, j, change);
            }
        }
        if(i - 1 > 0){
            if(board[i - 1][j] == 'O' && change[i - 1][j] == 0){
                change[i - 1][j] = 1;
                searchO(board, i - 1, j, change);
            }
        }
        if(j + 1 < board[0].length){
            if(board[i][j + 1] == 'O' && change[i][j + 1] == 0){
                change[i][j + 1] = 1;
                searchO(board, i, j + 1, change);
            }
        }
        if(j - 1 > 0){
            if(board[i][j - 1] == 'O' && change[i][j - 1] == 0){
                change[i][j - 1] = 1;
                searchO(board, i, j - 1, change);
            }
        }
    }
}
