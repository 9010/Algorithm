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
        Node root = new Node();
        root.val = 1;
        root.left = new Node();
        root.left.val = 2;
        root.right = new Node();
        root.right.val = 3;
        PopulatingNextRightPointersinEachNode tmp = new PopulatingNextRightPointersinEachNode();
        tmp.connect(root);

    }
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> tmp = new LinkedList<>();
        tmp.offer(root);
        while(!tmp.isEmpty()){
            int num = tmp.size();
            for(int i = 0; i < num; i++){
                Node tmpNode = tmp.poll();
                tmpNode.next = i == num - 1 ? null : tmp.peek();
                if(tmpNode.left != null) tmp.offer(tmpNode.left);
                if(tmpNode.right != null) tmp.offer(tmpNode.right);
            }
        }
        return root;
    }
}
