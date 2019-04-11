package cn.com.self;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 2019.4.1 zx
 * 自己的算法利用了递归，第一名算法使用栈，将Listnode.val值压入栈，在pop放入list实现翻转
 */

public class ListFromTailToHead {
    public static void main(String[] args) {
        ListNode node = new ListNode(20);
        node.next = new ListNode(30);

        ListFromTailToHead listFromTailToHead = new ListFromTailToHead();
        ArrayList<Integer> result = listFromTailToHead.printListFromTailToHead(node);
        System.out.println(result);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();

        if(listNode != null){
            result = recursiveLookup(result, listNode);
        }

        return result;
    }

    private ArrayList<Integer> recursiveLookup(ArrayList<Integer> result, ListNode listNode){
        if(listNode.next != null){
            result = recursiveLookup(result, listNode.next);
        }
        result.add(listNode.val);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
