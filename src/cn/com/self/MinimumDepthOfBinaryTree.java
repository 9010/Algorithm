package cn.com.self;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 二叉树层次遍历，找到第一个叶子节点
 */

public class MinimumDepthOfBinaryTree {
    int min = 0;

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);

        MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
        int min = test.run(tree);
        System.out.println(min);
    }

    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
