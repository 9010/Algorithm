package cn.com.self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 求树深度
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthofBinaryTree tmp = new MaximumDepthofBinaryTree();
        System.out.println(tmp.maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.offer(root);
        int level = 0;

        while(!tmp.isEmpty()){
            int levelNum = tmp.size();
            for(int i = 0; i < levelNum; i++){
                TreeNode n = tmp.poll();
                if(n.left != null){
                    tmp.offer(n.left);
                }
                if(n.right != null){
                    tmp.offer(n.right);
                }
            }
            level++;
        }
        return level;
    }
}
