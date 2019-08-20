package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * 2019.8.20 zx
 * 从下层往上层计算
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(-1);
        triangle.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(2); tmp.add(3);
        triangle.add(new ArrayList<>(tmp));
        tmp.clear();
        tmp.add(1); tmp.add(-1); tmp.add(-3);
        triangle.add(new ArrayList<>(tmp));
//        tmp.clear();
//        tmp.add(4); tmp.add(1); tmp.add(8); tmp.add(3);
//        triangle.add(new ArrayList<>(tmp));

        Triangle test = new Triangle();
        System.out.println(test.minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // opt[i][j] is the path sum start from one node of bottom layer to node (i,j)
        int[][] opt = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                opt[i][j] = Math.min(opt[i+1][j],opt[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return opt[0][0];
    }
}
