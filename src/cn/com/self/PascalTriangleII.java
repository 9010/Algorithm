package cn.com.self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * 2019.8.15 zx
 * 从左到右依次相加
 * 例：第5行： 一开始初始化 [1, 1, 1, 1, 1, 1] 六个 1
 * 从倒数第二位开始，这一位+后一位，重复（比如第二次就是倒数第三位+倒数第二位，倒数第二位再+最后一位），对应1+1=2 ，2+1=3 ， 3+2=5
 * 依次类推
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        int rowIndex = 5;
        PascalTriangleII tmp = new PascalTriangleII();
        System.out.println(tmp.getRow(rowIndex).toString() );
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>(Collections.nCopies(rowIndex+1, 1));
        for (int i = 1; i < rowIndex; i++) {
            for (int j = rowIndex-i; j < rowIndex; j++) // from left to right
                ret.set(j, ret.get(j) + ret.get(j+1));
        }
        return ret;
    }
}
