package cn.com.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * 2019.8.13 zx
 * 要求从下往上输出每一层
 * 先计算从上往下，最后把链表翻转一下
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversalII tmp = new BinaryTreeLevelOrderTraversalII();
        System.out.println(tmp.levelOrderBottom(root).toString());
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tmpResult = new ArrayList<>();
        if(root == null) return tmpResult;

        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.offer(root);

        while(!tmp.isEmpty()){
            List<Integer> tmpList = new ArrayList<>();
            int levelNum = tmp.size();
            for(int i = 0; i < levelNum; i++){
                TreeNode n = tmp.poll();
                tmpList.add(n.val);
                if(n.left != null){
                    tmp.offer(n.left);
                }
                if(n.right != null){
                    tmp.offer(n.right);
                }
            }
            tmpResult.add(tmpList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = tmpResult.size() - 1; i >= 0; i--){
            result.add(tmpResult.get(i));
        }
        return result;
    }
}
