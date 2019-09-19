package cn.com.self;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains
 * an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 2019.9.19 zx
 * DFS，注意next和random可能为null
 */
public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> copy = new HashMap<>();
        copyNode(head, copy);
        return copy.get(head);
    }

    private void copyNode(Node node, Map<Node, Node> copy){
        if(copy.containsKey(node)) return;

        Node copyedNode = new Node(node.val, new Node(), new Node());
        copy.put(node, copyedNode);
        if(node.next != null) {
            copyNode(node.next, copy);
            Node copyNext = copy.get(node.next);
            copyedNode.next = copyNext;
        }
        else {
            copyedNode.next = null;
        }
        if(node.random != null) {
            copyNode(node.random, copy);
            Node copyRandom = copy.get(node.random);
            copyedNode.random = copyRandom;
        }
        else{
            copyedNode.random = null;
        }
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
