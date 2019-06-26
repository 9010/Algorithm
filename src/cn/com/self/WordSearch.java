package cn.com.self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * 2019.6.25 zx
 * DFS计算，题目要求找到矩阵里是上下左右连续的字母，连在一起是要求的word
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch tmp = new WordSearch();
        System.out.println(tmp.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if(m ==0 || n == 0) return false;
        Map<Character, Integer> charNum = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && DFS(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, String word, int start, int r, int c){
        if(start >= word.length()) return true;
        if(r < 0 || c < 0
                || r >= board.length || c >= board[0].length
                || board[r][c] == '0'
                || board[r][c] != word.charAt(start))
            return false;
        char tmp = board[r][c];
        board[r][c] = '0';
        if(DFS(board, word, start + 1, r + 1, c)
                || DFS(board, word, start + 1, r - 1, c)
                || DFS(board, word, start + 1, r, c + 1)
                || DFS(board, word, start + 1, r, c - 1)){
            return true;
        }
        board[r][c] = tmp;

        return false;
    }
//        System.out.println(charNum.toString());
//        for(int i = 0; i < word.length(); i++){
//            if(!charNum.containsKey(word.charAt(i))){
//                return false;
//            }
//            else{
//                if(charNum.get(word.charAt(i)) - 1 < 0){
//                    return false;
//                }
//                charNum.put(word.charAt(i), charNum.get(word.charAt(i)) - 1);
//            }
//        }
}
