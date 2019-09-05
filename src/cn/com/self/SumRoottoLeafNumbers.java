package cn.com.self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 */
public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(0);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        SumRoottoLeafNumbers tmp = new SumRoottoLeafNumbers();
        System.out.println(tmp.sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

    }
}
