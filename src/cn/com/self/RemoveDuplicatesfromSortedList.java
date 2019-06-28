package cn.com.self;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * 2019.6.28 zx
 * 顺序读取链表中的内容，发现重复则跳过，将不重复的数字存入新的链表中，最后返回新的链表
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode test = new ListNode(2);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = new ListNode(4);
        RemoveDuplicatesfromSortedList tmp = new RemoveDuplicatesfromSortedList();
        test = tmp.deleteDuplicates(test);
        while(test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head;
        ListNode tmp1 = head;
        ListNode tmp2 = head;
        while(tmp2 != null){
            tmp2 = tmp2.next;
            if(tmp2 != null && tmp1.val == tmp2.val){
                while(tmp2 != null && tmp1.val == tmp2.val){
                    tmp2 = tmp2.next;
                }
            }
            head.next = tmp2;
            head = head.next;
            tmp1 = tmp2;
        }
        return res;
    }
}
