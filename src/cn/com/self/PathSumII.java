package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 */
public class PathSumII {
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

        PathSumII tmp = new PathSumII();
        System.out.println(tmp.pathSum(root, 22).toString());
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        return helper(result, new ArrayList<>(), root, sum, 0);
    }

    private List<List<Integer>> helper(List<List<Integer>> result, List<Integer> tmpList, TreeNode root, int sum, int tmp){
        tmp += root.val;
        tmpList.add(root.val);
        if(root.left != null){
            result = helper(result, tmpList, root.left, sum ,tmp);
        }
        if(root.right != null){
            result = helper(result, tmpList, root.right, sum, tmp);
        }
        if(tmp == sum && root.left == null && root.right == null){
            result.add(new ArrayList<>(tmpList));
        }
        tmpList.remove(tmpList.size() - 1);
        tmp -= root.val;
        return result;
    }
}
