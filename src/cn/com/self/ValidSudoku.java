package cn.com.self;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * 2019.5.22 zx
 * LeetCode 一个很好的解法
 *
 * Collect the set of things we see, encoded as strings. For example:
 * '4' in row 7 is encoded as "(4)7".
 * '4' in column 7 is encoded as "7(4)".
 * '4' in the top-right block is encoded as "0(4)2".
 * Scream false if we ever fail to add something because it was already added (i.e., seen before).
 *
 * 但是时间不是最快的，考虑是set里的问题
 */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||    //利用Set不能存入相同数据的特性，存入数据，发现无法存入就返回false
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
