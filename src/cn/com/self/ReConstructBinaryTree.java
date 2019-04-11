package cn.com.self;


import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 中序遍历一定是{左子树中的节点集合}，root，{右子树中的节点集合}，
 * 前序遍历的作用是找到每颗子树的root位置。
 *
 * 2019.4.2 zx
 * 未成功解题，注释部分为自己写的，未注释部分为牛客网答案
 */

public class ReConstructBinaryTree {
    public static void main(String[] args) {
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        int [] pre = new int[]{1,2,3,4,5,6,7};
        int [] in = new int[]{3,2,4,1,6,5,7};
        reConstructBinaryTree.reConstructBinaryTree(pre, in);
    }

//    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
//        TreeNode treeNode = null;
//        int i, root = 0;
//
//        if (pre != null || in != null){
//            treeNode = new TreeNode(pre[0]);
//
//            for (i = 0; i < in.length; i++){
//                if (pre[0] == in[i]){
//                    break;
//                }
//                root++;
//            }
//
//            int [] preLeft = new int[root];
//            int [] inLeft = new int[root];
//            int [] preRight = new int[pre.length - root];
//            int [] inRight = new int[in.length - root];
//
//            for (i = 0; i < root; i++){
//                preLeft[i] = pre[i+1];
//                inLeft[i] = in[i];
//            }
//            int j;
//            for (j = 0, i = root + 1; i < in.length; i++, j++){
//                preRight[j] = pre[i];
//                inRight[j] = in[i];
//            }
//            treeNode.left = reConstructBinaryTree(preLeft, inLeft);
//            treeNode.right = reConstructBinaryTree(preRight, inRight);
//        }
//
//        return treeNode;
//    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }

        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        System.out.println(map);
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    public TreeNode preIn(int[] pre,int pi,int pj,int[] in,int ni,int nj, HashMap<Integer,Integer> map){

        if(pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre,pi+1,pi+index-ni,in,ni,index-1,map);
        head.right = preIn(pre,pi+index-ni+1,pj,in,index+1,nj,map);
        return head;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
