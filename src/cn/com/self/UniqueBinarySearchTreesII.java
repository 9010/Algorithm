package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * DFS
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesII tmp = new UniqueBinarySearchTreesII();
        System.out.println(tmp.generateTrees(n).toString());
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0) return result;

        helper(result, n);

        return result;
    }

    private void helper(List<TreeNode> result, int n){


    }
}
