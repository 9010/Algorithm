package cn.com.self;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
//        test.next.next = new ListNode(3);
//        test.next.next.next = new ListNode(4);
//        test.next.next.next.next = new ListNode(5);
        ReverseLinkedListII tmp = new ReverseLinkedListII();
        int m = 1, n = 2;
        test = tmp.reverseBetween(test, m, n);
        while(test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        ListNode tmp1 = head, tmp2= head;
        int index = 1;
        while(head != null){
            if(m != 1){
                if(index == m - 1){
                    tmp1 = head;
                    tmp2 = head.next;
                }
                if (index == n - 1) {
                    ListNode tmpNext = tmp2.next;
                    tmp1.next = head.next;
                    tmp2.next = head.next.next;
                    head.next.next = tmpNext;
                    head.next = tmp2;

                    break;
                }
            }
            else if (m == 1){
                if (index == n - 1) {
                    ListNode tmpNext = tmp2.next;
                    result = head.next;
                    tmp2.next = head.next.next;
                    head.next.next = tmpNext;
                    head.next = tmp2;

                    break;
                }
            }
            index++;
            head = head.next;
        }

        return result;
    }
}
