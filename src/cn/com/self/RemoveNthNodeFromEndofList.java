package cn.com.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head
 *
 * 2019.5.9 zx
 * 将整个链表节点存入一个List中，直接找到删除节点即可，一次遍历
 * 注意各种极端情况
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList tmp = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = tmp.removeNthFromEnd(head, 1);
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        ListNode result = head;
        List<ListNode> tmp = new LinkedList<>();

        while(result != null){
            tmp.add(result);
            result = result.next;
        }
        int index = tmp.size() - n;
        if (index == 0){
            head = tmp.get(index + 1);
        }
        else if(index + 1 > tmp.size() - 1) {
            tmp.get(index - 1).next = null;
        }
        else {
            tmp.get(index - 1).next = tmp.get(index + 1);
        }

        return head;
    }
}
