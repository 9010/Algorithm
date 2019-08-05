package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal (中序遍历) of its nodes' values.
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 *
 * 2019.8.5 zx
 * 最基础的二叉树中序遍历
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal tmp = new BinaryTreeInorderTraversal();
        System.out.println(tmp.inorderTraversal(root).toString());
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        helper(result, root);

        return result;
    }

    private void helper(List<Integer> result, TreeNode root){
        if(root.left != null)  helper(result, root.left);

        result.add(root.val);

        if(root.right != null)  helper(result, root.right);
    }
}
