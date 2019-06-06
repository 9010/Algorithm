package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * 2019.6.6 zx
 * 与NQueen相似，区别在于输出数量
 */
public class NQueensII {
    public static void main(String[] args) {
        int n = 4;
        NQueensII tmp = new NQueensII();
        System.out.println(tmp.solveNQueens(n));
    }
    public int solveNQueens(int n) {
        boolean[] used = new boolean[n];
        boolean[] right = new boolean[n * 2];
        boolean[] left = new boolean[n * 2];
        int solution = 0;
        return BackList(solution, new ArrayList<String>(), used, right, left, n, 0);
    }

    private int BackList(int solution, ArrayList<String> templist, boolean[] used, boolean[] right, boolean[] left, int n, int deep) {
        if (templist.size() == n) {
            return solution + 1;
        } else {
            for (int i = 0; i < n; i++) {
                int r = i - deep + n;
                int l = i + deep;
                if(!used[i] && !right[r] && !left[l]){
                    templist.add(String.valueOf(i));
                    used[i] = true;
                    right[r] = true;
                    left[l] = true;
                }
                else{
                    continue;
                }
                solution = BackList(solution, templist, used, right, left, n, deep+1);
                templist.remove(templist.size() - 1);
                used[i] = false;
                right[r] = false;
                left[l] = false;
            }
        }
        return solution;
    }
}
