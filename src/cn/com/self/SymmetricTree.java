package cn.com.self;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 2019.8.7 zx
 * 利用之前SameTree的解法，判断左子树的右子树是否与右子数的左子树相同即可
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree tmp = new SymmetricTree();
        System.out.println(tmp.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
       return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;  //包括p == null && q == null的情况 以及p和q是同一棵树的情况
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
