package cn.com.self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 根据中序和后序，确定二叉树
 *
 * 2019.8.13 zx
 * 前序遍历的第一个结点必定是根结点，后序遍历的最后一个结点一定是根结点，根据前序遍历或者后续遍历很容易就能找到根结点。
 * 如果树中不存在重复结点，那么在中序遍历中，根结点所在位置的左边就是左子树的中序遍历结果，右边就是右子树的中序遍历结果。
 * 对于inorder = {9,3,15,20,7} 与 postorder = {9,15,7,20,3} 而言
 * postorder最后一位3就是根节点，那么在inorder中3的左右分别的左子树和右子树
 * 同时，也对应了postorder中，3的前3位为右子树，右子树再前1位为左子树
 * 一步步分解
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        ConstructBinaryTreefromInorderandPostorderTraversal tmp = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode root = tmp.buildTree(inorder, postorder);
        BinaryTreeInorderTraversal tmp2 = new BinaryTreeInorderTraversal();
        System.out.println(tmp2.inorderTraversal(root).toString());
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length - 1,  0, inorder.length - 1, inMap);
        return root;
    }
    public TreeNode buildTree(int[] postorder, int postStart, int postEnd,
                              int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(postorder, postStart, postStart + numsLeft - 1,
                inStart, inRoot - 1, inMap);
        root.right = buildTree(postorder, postStart + numsLeft, postEnd - 1,
                inRoot + 1, inEnd, inMap);

        return root;
    }
}
