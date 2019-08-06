package cn.com.self;

import com.sun.javaws.jnl.RContentDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * 根据中序排序和后序排序 或者 先序排序和中序排序可以确定一颗二叉树
 * 那么两颗二叉树的中序和后序 或者 先序和中序 排序相同的话，就是一颗二叉树
 * 否决！ 此题目中会存在相同值的结点，不能使用此方法
 * 例：        1         1
 *           /           \
 *          1             1
 * 此例中两个二叉树先序和中序均为[1, 1]，但结构不同
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.left.right =new TreeNode(3);

        SameTree tmp = new SameTree();
        System.out.println(tmp.isSameTree(p, q));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;  //包括p == null && q == null的情况 以及p和q是同一棵树的情况
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
