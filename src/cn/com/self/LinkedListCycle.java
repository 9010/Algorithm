package cn.com.self;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * 2019.9.23 zx
 * 快慢指针法
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next  = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycle tmp = new LinkedListCycle();
        System.out.println(tmp.hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (s != null && f != null && f.next != null)  {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                return true;
            }
        }

        return false;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
