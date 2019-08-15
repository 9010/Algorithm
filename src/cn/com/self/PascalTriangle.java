package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * 2019.8.15 zx
 */

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;

        PascalTriangle tmp = new PascalTriangle();
        System.out.println(tmp.generate(numRows).toString());
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> tmp = new ArrayList<>();

        tmp.add(1);
        result.add(new ArrayList<>(tmp));
        if(numRows == 1){
            return result;
        }
        tmp.add(1);
        result.add(new ArrayList<>(tmp));
        if(numRows == 2){
            return result;
        }

        for(int i = 3; i <= numRows; i++){
            List<Integer> nextLevel = new ArrayList<>();
            nextLevel.add(1);
            for(int j = 1; j < i - 1; j++){
                nextLevel.add(tmp.get(j - 1) + tmp.get(j));
            }
            nextLevel.add(1);
            result.add(nextLevel);
            tmp = nextLevel;
        }
        return result;
    }
}
