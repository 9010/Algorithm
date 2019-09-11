package cn.com.self;

/**
 * 通用Node节点类
 */
public class NormalNode {
    public int val;
    public NormalNode left;
    public NormalNode right;
    public NormalNode next;

    public NormalNode() {}

    public NormalNode(int _val, NormalNode _left, NormalNode _right, NormalNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
