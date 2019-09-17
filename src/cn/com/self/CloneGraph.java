package cn.com.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * 2019.9.17 zx
 * DFS
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> clones = new HashMap<>();
        cloneNodes(node, clones);
        return clones.get(node);
    }

    private void cloneNodes(Node node, Map<Node, Node> clones){
        if(clones.containsKey(node)) return;

        Node clone = new Node(node.val, new ArrayList<>());
        clones.put(node, clone);
        for(Node neighbor : node.neighbors){
            cloneNodes(neighbor, clones);
            Node cloneNeighbors = clones.get(neighbor);
            clone.neighbors.add(cloneNeighbors);
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
