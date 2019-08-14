package cn.com.self;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * 2019.8.14 zx
 * 对于 “ 任意 ” 一个节点，左右子树深度不能相差大于 1
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BalancedBinaryTree tmp = new BalancedBinaryTree();
        System.out.println(tmp.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        if(Math.abs(left - right) <= 1) {
//            if(isBalanced(root.left) && isBalanced(root.right)){
//                return true;
//            }
//            else return false;
//        }
//        else return false;
//    }
//
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        Queue<TreeNode> tmp = new LinkedList<>();
//        tmp.offer(root);
//        int level = 0;
//
//        while(!tmp.isEmpty()){
//            int levelNum = tmp.size();
//            for(int i = 0; i < levelNum; i++){
//                TreeNode n = tmp.poll();
//                if(n.left != null){
//                    tmp.offer(n.left);
//                }
//                if(n.right != null){
//                    tmp.offer(n.right);
//                }
//            }
//            level++;
//        }
//        return level;
//    }
}
