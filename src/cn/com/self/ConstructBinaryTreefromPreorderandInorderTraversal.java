package cn.com.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 根据前序和中序给出二叉树
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTreefromPreorderandInorderTraversal tmp = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = tmp.buildTree2(preorder, inorder);
        BinaryTreeInorderTraversal tmp2 = new BinaryTreeInorderTraversal();
        System.out.println(tmp2.inorderTraversal(root).toString());
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode res = new TreeNode(preorder[0]);
        int i, j, k;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                break;
            }
        }
        int[] inleft = new int[i];
        int[] inright = new int[inorder.length - i - 1];
        int[] preleft = new int[i];
        int[] preright = new int[inorder.length - i - 1];
        for(j = 0, k = 0; j < inorder.length; j++){
            if(j < i){
                inleft[j] = inorder[j];
                preleft[j] = preorder[j + 1];
            }
            else if(j > i){
                inright[k] = inorder[j];
                preright[k] = preorder[j];
                k++;
            }
        }
        res.left = buildTree(preleft, inleft);
        res.right = buildTree(preright, inright);

        return res;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder,
                              int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder,
                inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder,
                inRoot + 1, inEnd, inMap);

        return root;
    }
}
