package cn.com.self;

/**
 * Given a linked list and a value x, partition it
 * such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
//        test.next = new ListNode(4);
//        test.next.next = new ListNode(3);
//        test.next.next.next = new ListNode(2);
//        test.next.next.next.next = new ListNode(5);
//        test.next.next.next.next.next = new ListNode(2);
        PartitionList tmp = new PartitionList();
        test = tmp.partition(test, 0);
        while(test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode less = new ListNode(0), more = new ListNode(0);
        ListNode res = less, moreHead = more;
        while(head != null){
            if(head.val < x){
                less.next = new ListNode(head.val);
                less = less.next;
            }
            else if(head.val >= x){
                more.next = new ListNode(head.val);
                more = more.next;
            }
            head = head.next;
        }
        less.next = moreHead.next;
        return res.next;
    }
}
