package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        FlattenBinaryTreetoLinkedList tmp = new FlattenBinaryTreetoLinkedList();
        tmp.flatten(root);
        BinaryTreeInorderTraversal sout = new BinaryTreeInorderTraversal();
        System.out.println(sout.inorderTraversal(root));
    }
    public void flatten(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left != null){
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null)
                root = root.right;
            root.right = tempRight;
        }
        flatten(root.right);
    }
    public void flatten2(TreeNode root) {
        if(root == null) return;
        List<Integer> inorder = new ArrayList<>();
        helper(inorder, root);
        System.out.println(inorder.toString());
        TreeNode tmp = root;
        tmp.right = null; tmp.left = null;
        for(int i = 1; i < inorder.size(); i++){
            tmp.right = new TreeNode(inorder.get(i));
            tmp = tmp.right;
        }
    }

    private void helper(List<Integer> result, TreeNode root){
        result.add(root.val);
        if(root.left != null)  helper(result, root.left);
        if(root.right != null)  helper(result, root.right);
    }
}
