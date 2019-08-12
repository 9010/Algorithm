package cn.com.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 层次遍历
 *
 * 2019.8.12 zx
 * 层次遍历，用FIFO队列
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal tmp = new BinaryTreeLevelOrderTraversal();
        System.out.println(tmp.levelOrder(root).toString());
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<Integer> tmpList = new ArrayList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        tmp.offer(root);
        levelQueue.offer(1);
        int level = 1;

        while(!tmp.isEmpty()){
            if(tmp.peek().left != null){
                tmp.offer(tmp.peek().left);
                levelQueue.offer(levelQueue.peek() + 1);
            }
            if(tmp.peek().right != null){
                tmp.offer(tmp.peek().right);
                levelQueue.offer(levelQueue.peek() + 1);
            }
            tmpList.add(tmp.poll().val);
            levelQueue.poll();
            if(levelQueue.isEmpty() || level != levelQueue.peek()){
                result.add(new ArrayList<>(tmpList));
                tmpList.clear();
                if(!levelQueue.isEmpty()) level = levelQueue.peek();
            }
        }
        return result;
    }
}
