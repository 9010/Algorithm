package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * 2019.5.12 zx
 * 整个链表存入一个List中，翻转完成后，统一修改next
 */

public class SwapNodesinPairs {
    public static void main(String[] args) {
        SwapNodesinPairs tmp = new SwapNodesinPairs();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);

        ListNode result = tmp.swapPairs(test);
        while(result != null){
            System.out.print(result.val + "-");
            result = result.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        List<ListNode> result = new ArrayList<>();

        while(head != null){
            result.add(head);
            head = head.next;
        }

        for (int i = 0; i < result.size() - 1; i = i + 2){
            ListNode tmp;
            tmp = result.get(i);
            result.set(i, result.get(i + 1));
            result.set(i + 1, tmp);
        }
        for(int i = 0; i < result.size() - 1; i++){
            result.get(i).next = result.get(i + 1);
        }
        result.get(result.size() - 1).next = null;

        return result.get(0);
    }
}
