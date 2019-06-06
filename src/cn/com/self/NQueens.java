package cn.com.self;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * 2019.6.6 zx
 * 与非攻击性车相似，不同的是国际象棋中“女王”棋子，可以斜着走！！！
 * 所以除了要计算横向和纵向不能冲突之外，还要计算斜向不能冲突，所以这题Hard难度
 * 斜向计算方法：
 *      向右斜向即：“\”这个方向，此方向上的下标有此特性：相减的数值相等，即：col-row的值相等，为便于计算，加上n使其为正
 *      向左倾斜即：“/”这个方向，此方向上的下标有此特性：相加的数值相等，即：col+row的值相等
 *      建立两个数组right和left，大小为2n（因为相加最大为2n，相减不是但为了统一），分别记录左右斜向的占用情况即可
 */
public class NQueens {
    public static void main(String[] args) {
        int n = 9;
        NQueens tmp = new NQueens();
        List<List<String>> result = tmp.solveNQueens(n);
        System.out.println(result);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        boolean[] right = new boolean[n * 2];
        boolean[] left = new boolean[n * 2];
        BackList(result, new ArrayList<>(), used, right, left, n, 0);
        return result;
    }

    private void BackList(List<List<String>> result, ArrayList<String> templist, boolean[] used, boolean[] right, boolean[] left, int n, int deep) {
        if (templist.size() == n) {
            result.add(new ArrayList<>(templist));
        } else {
            for (int i = 0; i < n; i++) {
                int r = i - deep + n;
                int l = i + deep;
                if(!used[i] && !right[r] && !left[l]){
                    StringBuilder tmp = new StringBuilder();
                    for(int j = 0; j < n; j++){
                        if(j == i){
                            tmp.append('Q');
                        }
                        else{
                            tmp.append('.');
                        }
                    }
                    templist.add(tmp.toString());
                    used[i] = true;
                    right[r] = true;
                    left[l] = true;
                }
                else{
                    continue;
                }
                BackList(result, templist, used, right, left, n, deep+1);
                templist.remove(templist.size() - 1);
                used[i] = false;
                right[r] = false;
                left[l] = false;
            }
        }
    }
}
