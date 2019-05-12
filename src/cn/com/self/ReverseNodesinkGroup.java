package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * 2019.5.12 zx
 * ListNode存入一个List，找K+1节点，翻转放入另一个List，直到找不到新的K+1，把剩下的放入List中，最后修改Next
 */
public class ReverseNodesinkGroup {
    public static void main(String[] args) {
        ReverseNodesinkGroup tmp = new ReverseNodesinkGroup();
        int k = 3;
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);

        ListNode result = tmp.reverseKGroup(test, k);
        while(result != null){
            System.out.print(result.val + "-");
            result = result.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        List<ListNode> tmp = new ArrayList<>();
        List<ListNode> result = new ArrayList<>();

        while(head != null){
            tmp.add(head);
            head = head.next;
        }
        int i;
        for(i = 0; i < tmp.size(); i = i + k){
            if(tmp.size() - i < k){
                break;
            }
            for(int j = 1; j <= k; j++){
                result.add(tmp.get(i + k - j));
            }
        }

        for(; i < tmp.size(); i++){
            result.add(tmp.get(i));
        }

        for(i = 0; i < result.size() - 1; i++){
            result.get(i).next = result.get(i + 1);
        }
        result.get(result.size() - 1).next = null;

        return result.get(0);
    }

    //递归算法，算法时间复杂度较低（大概） 中间 while (count-- > 0) 是主要，但不是很懂
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null && count != k) { // find the k+1 node
//            curr = curr.next;
//            count++;
//        }
//        if (count == k) { // if k+1 node is found
//            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
//            // head - head-pointer to direct part,
//            // curr - head-pointer to reversed part;
//            while (count-- > 0) { // reverse current k-group:
//                ListNode tmp = head.next; // tmp - next head in direct part
//                head.next = curr; // preappending "direct" head to the reversed list
//                curr = head; // move head of reversed part to a new node
//                head = tmp; // move "direct" head to the next node in direct part
//            }
//            head = curr;
//        }
//        return head;
//    }
}
