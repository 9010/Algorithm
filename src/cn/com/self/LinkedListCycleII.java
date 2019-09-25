package cn.com.self;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * 2019.9.23 zx
 * 记下算法。。
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next  = new ListNode(-4);
        head.next.next.next.next = head.next;

        LinkedListCycleII tmp = new LinkedListCycleII();
        System.out.println(tmp.detectCycle(head));
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;   // no circle
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {  // circle detected
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null; // no circle
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
