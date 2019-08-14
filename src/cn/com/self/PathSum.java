package cn.com.self;

import java.nio.file.Path;

/**
 * Given a binary tree and a sum, determine if the tree has
 * a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * 2019.8.14 zx
 * 简单难度
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum tmp = new PathSum();
        System.out.println(tmp.hasPathSum(root, 20));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int tmp){
        tmp += root.val;
        boolean left = false, right = false;
        if(root.left != null){
            left = helper(root.left, sum ,tmp);
        }
        if(root.right != null){
            right = helper(root.right, sum, tmp);
        }
        if(tmp == sum && root.left == null && root.right == null){
            return true;
        }
        return (left || right);
    }
}
