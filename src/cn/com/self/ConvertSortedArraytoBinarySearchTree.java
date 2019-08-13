package cn.com.self;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 数组转为平衡二叉树
 *
 * 2019.8.13 zx
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ConvertSortedArraytoBinarySearchTree tmp = new ConvertSortedArraytoBinarySearchTree();
        TreeNode root = tmp.sortedArrayToBST(nums);
        BinaryTreeInorderTraversal out = new BinaryTreeInorderTraversal();
        System.out.println(out.inorderTraversal(root).toString());
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }


    public TreeNode sortedArrayToBST(int[] a, int l, int r) { //还是分布计算每一小块树，从最小的开始
        if(l == r) return new TreeNode(a[l]);

        if(l+1 == r){
            TreeNode n1 = new TreeNode(a[l]);
            TreeNode n2 = new TreeNode(a[r]);
            n2.left = n1;
            return n2;
        }
        int mid = l + (r-l)/2;

        TreeNode root = new TreeNode(a[mid]);

        root.left = sortedArrayToBST(a, l, mid-1);
        root.right = sortedArrayToBST(a, mid+1, r);

        return root;
    }
}
