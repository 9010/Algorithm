package cn.com.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * DFS X
 * 2019.8.6 zx
 * 一开始看到求全部节，想到DFS，但事实上，这里存在一个问题，由于返回是数的头结点，所以用DFS有问题（可能还存在其他问题）
 * 应该使用动态规划，从最小树开始求，例如 n = 4 ，就从 n = 1 开始，一步步算出所有可能的子树，再将1-4作为头结点，加入左右子树
 * 这个解法还是有些问题，空间使用不太对，应该不需要用递归
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesII tmp = new UniqueBinarySearchTreesII();
        System.out.println(tmp.generateTrees(n).toString());
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();

        return DP(1, n);
    }

    private List<TreeNode> DP(int si, int ei){
        if(si > ei){
            List<TreeNode> br = new ArrayList<>();
            br.add(null);
            return br;
        }

        List<TreeNode> result = new ArrayList<>();
        for(int i = si; i <= ei; i++){
            List<TreeNode> lr = DP(si, i - 1);  //左子树
            List<TreeNode> rr = DP(i + 1, ei);  //右子数
            for(int j = 0; j < lr.size(); j++){
                for(int k = 0; k < rr.size(); k++){
                    TreeNode nn = new TreeNode(i);
                    nn.left = lr.get(j);
                    nn.right = rr.get(k);
                    result.add(nn);
                }
            }
        }
        return result;
    }
}
