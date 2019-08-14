package cn.com.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 二叉树层次遍历，找到第一个叶子节点，其层数就是最小层数
 *
 * 2019.5.6 zx
 */

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.right = new TreeNode(7);
        tree.right.left = new TreeNode(15);

        MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
        System.out.println(test.minDepth(tree));
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        ArrayList<Integer> deep = new ArrayList<>();
        int n = 0;
        tree.offer(root);
        deep.add(1);
        while (tree.element().left != null || tree.element().right != null){
            if(tree.element().left != null){
                tree.offer(tree.element().left);
                deep.add(deep.get(n) + 1);
                if (tree.element().left.left == null && tree.element().left.right == null){
                    break;
                }
            }
            if(tree.element().right != null){
                tree.offer(tree.element().right);
                deep.add(deep.get(n) + 1);
                if (tree.element().right.left == null && tree.element().right.right == null){
                    break;
                }
            }
            tree.poll();
            n++;
        }
        return deep.get(deep.size() - 1);
    }
}
