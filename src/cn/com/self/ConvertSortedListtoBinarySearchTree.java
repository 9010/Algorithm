package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * 2019.8.14 zx
 * 先把ListNode转换成ArrayList，在和数组一样操作
 * 时间复杂度略差，空间复杂度较好
 */
public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        ListNode tree = node;
        int[] nums = {-3, 0, 5, 9};
        for(int i = 0; i < nums.length; i++){
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        ConvertSortedListtoBinarySearchTree tmp = new ConvertSortedListtoBinarySearchTree();
        TreeNode root = tmp.sortedListToBST(tree);
        BinaryTreeInorderTraversal out = new BinaryTreeInorderTraversal();
        System.out.println(out.inorderTraversal(root).toString());
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> tmp = new ArrayList<>();
        while(head != null){
            tmp.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(tmp, 0, tmp.size() - 1);
    }
    public TreeNode sortedArrayToBST(List<Integer> a, int l, int r) { //还是分布计算每一小块树，从最小的开始
        if(l == r) return new TreeNode(a.get(l));

        if(l+1 == r){
            TreeNode n1 = new TreeNode(a.get(l));
            TreeNode n2 = new TreeNode(a.get(r));
            n2.left = n1;
            return n2;
        }
        int mid = l + (r-l)/2;

        TreeNode root = new TreeNode(a.get(mid));

        root.left = sortedArrayToBST(a, l, mid-1);
        root.right = sortedArrayToBST(a, mid+1, r);

        return root;
    }
}
