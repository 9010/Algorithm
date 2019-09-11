package cn.com.self;

import java.util.LinkedList;
import java.util.Queue;

/**
 *You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * 2019.8.15 zx
 * 层次遍历，每一层节点依次加上next后一个节点，注意最后一个节点next为null
 */
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        NormalNode root = new NormalNode();
        root.val = 1;
        root.left = new NormalNode();
        root.left.val = 2;
        root.right = new NormalNode();
        root.right.val = 3;
        PopulatingNextRightPointersinEachNode tmp = new PopulatingNextRightPointersinEachNode();
        tmp.connect(root);

    }
    public NormalNode connect(NormalNode root) {
        if(root == null) return null;
        Queue<NormalNode> tmp = new LinkedList<>();
        tmp.offer(root);
        while(!tmp.isEmpty()){
            int num = tmp.size();
            for(int i = 0; i < num; i++){
                NormalNode tmpNormalNode = tmp.poll();
                tmpNormalNode.next = i == num - 1 ? null : tmp.peek();
                if(tmpNormalNode.left != null) tmp.offer(tmpNormalNode.left);
                if(tmpNormalNode.right != null) tmp.offer(tmpNormalNode.right);
            }
        }
        return root;
    }
}
