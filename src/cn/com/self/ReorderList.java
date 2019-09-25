package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * 2019.9.25 zx
 * 先存入一个List中，然后按照顺序 1, n-1, 2, n-2顺序取出数据，一次取两个，取list.size() / 2 次，注意 n-i 和 i 相同的情况,只取一个
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList tmp = new ReorderList();
        tmp.reorderList(head);

        while(head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }
    public void reorderList(ListNode head) {
        if(head == null) return;

        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }

        tmp = head;
        int n = 0, i = 1, j = list.size() - 1;
        while(n < (list.size() / 2)){
            if(j > list.size() / 2) {
                tmp.next = list.get(j);
                tmp = tmp.next;
                j--;
            }

            tmp.next = list.get(i);
            tmp = tmp.next;
            i++;

            n++;
        }
        tmp.next = null;
    }
}
