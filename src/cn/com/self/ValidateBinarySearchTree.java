package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * 2019.8.6 zx
 * 二叉搜索树（定义上网查），其中序排序是由小到大的，直接看中序排序即可
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1);

        ValidateBinarySearchTree tmp = new ValidateBinarySearchTree();
        System.out.println(tmp.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> tmp = new ArrayList<>();

        helper(tmp, root, 0);

        for(int i = 0; i < tmp.size() - 1; i++){
            if(tmp.get(i) > tmp.get(i + 1)) return false;
        }

        return true;
    }

    private void helper(List<Integer> tmp, TreeNode root, int index){
        if(root.left != null) {
            helper(tmp, root.left, index);
        }
        tmp.add(root.val);
        index++;
        if(root.right != null) {
            helper(tmp, root.right, index);
        }
    }
}
