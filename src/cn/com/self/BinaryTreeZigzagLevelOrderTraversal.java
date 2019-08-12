package cn.com.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ]Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 2019.8.12 zx
 * 层次遍历，用FIFO队列，思想一样，但是要求Z字型输出，就把每两行的链表翻转一下
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeZigzagLevelOrderTraversal tmp = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(tmp.zigzagLevelOrder(root).toString());
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;


        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.offer(root);
        int level = 1;

        while(!tmp.isEmpty()){
            List<Integer> tmpList = new ArrayList<>();
            int levelNum = tmp.size();
            for(int i = 0; i < levelNum; i++){
                TreeNode n = tmp.poll();
                tmpList.add(n.val);
                if (n.left != null) {
                    tmp.add(n.left);
                }
                if (n.right != null) {
                    tmp.add(n.right);
                }
            }
            if(level % 2 == 0){
                List<Integer> reverseTmpList = new ArrayList<>();
                for(int i = tmpList.size() - 1; i >= 0; i--){
                    reverseTmpList.add(tmpList.get(i));
                }
                result.add(reverseTmpList);
            }
            else{
                result.add(tmpList);
            }
            level++;
        }
        return result;
    }
}
