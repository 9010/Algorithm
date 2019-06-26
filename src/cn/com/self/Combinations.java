package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * 2019.6.25 zx
 * 递归
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        Combinations tmp = new Combinations();
        System.out.println(tmp.combine(n, k).toString());
    }
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        res = backList(res, tmp, n, k, 1);

        return res;
    }

    private List<List<Integer>> backList(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start){
        if(k == 0){
            res.add(new ArrayList<>(tmp)); //一定要加new ArrayList不然会出问题
            return res;
        }
        for(int i = start; i <= n; i++){
            tmp.add(i);
            k--;
            res = backList(res, tmp, n, k, i + 1);
            tmp.remove(tmp.size() - 1);
            k++;
        }
        return res;
    }
}
