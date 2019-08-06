package cn.com.self;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * 2019.8.6 zx
 * 思路：空树和只有根节点时，也为BST。
 * 对于一点i，当其为根节点时，左子树的节点的个数为i-1，（为1,...i-1）,右子树的个数为n-i（为，i+1,...n）。
 * 对一个根来说，唯一二叉树的个数为左子树结点的个数乘以右子树的个数。而根节点可以从1到n中选择。
 * 所有数存入DP数组中，对于DP[3] 那么为3种情况：根为1、2、3,数量分别为：DP[0] * DP[2] 、 DP[1] * DP[1] 、 DP[2] * DP[0]
 * 相加即为DP[3]
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTrees tmp = new UniqueBinarySearchTrees();
        System.out.println(tmp.numTrees(n));
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            for (int j=1;j<=i;j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
