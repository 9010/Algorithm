package cn.com.self;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers
 * leaving only distinct numbers from the original list.
 *
 * 2019.6.28 zx
 * 顺序读取链表中的内容，发现重复则跳过，将不重复的数字存入新的链表中，最后返回新的链表
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        ListNode test = new ListNode(2);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = new ListNode(4);
        RemoveDuplicatesfromSortedListII tmp = new RemoveDuplicatesfromSortedListII();
        test = tmp.deleteDuplicates(test);
        while(test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode help = res;
        ListNode tmp = head;
        while(tmp != null){
            tmp = tmp.next;
            if(tmp != null && head.val == tmp.val){
                while(tmp != null && head.val == tmp.val){
                    tmp = tmp.next;
                }
            }
            else {
                help.next = head;
                help = help.next;
            }
            head = tmp;
        }
        help.next = null;
        return res.next;
    }
}
