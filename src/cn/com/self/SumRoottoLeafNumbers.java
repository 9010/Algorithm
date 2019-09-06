package cn.com.self;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 * 2019.9.6 zx
 * DFS求每一次到叶子结点的数字，相加
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

        int sum = DFS(root, 0, new StringBuilder());

        return sum;
    }

    private int DFS(TreeNode root, int sum, StringBuilder tmpNum){
        tmpNum.append(root.val);
        if(root.right == null && root.left == null){
            int num = Integer.valueOf(tmpNum.toString());
            sum = sum + num;
            return sum;
        }
        if(root.right != null){
            sum = DFS(root.right, sum, tmpNum);
            tmpNum.deleteCharAt(tmpNum.length() - 1);
        }
        if(root.left != null){
            sum = DFS(root.left, sum, tmpNum);
            tmpNum.deleteCharAt(tmpNum.length() - 1);
        }
        return sum;
    }
}
