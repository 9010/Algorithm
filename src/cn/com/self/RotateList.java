package cn.com.self;

import java.util.Arrays;
import java.util.List;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * 2019.6.12 zx
 * 鏈表操作，還比較簡單
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode tmp = new ListNode(0);
        tmp.next = new ListNode(1);
        tmp.next.next = new ListNode(2);
        int k = 4;
        RotateList res = new RotateList();
        tmp = res.rotateRight(tmp, k);
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int listLen = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            listLen++;
            tmp = tmp.next;
        }
        ListNode end = tmp;
        k = listLen - k % listLen;
        if(k == 0) return head;
        tmp = head;
        ListNode res;
        while(tmp.next != null){
            if(k == 1){
                end.next = head;
                head = tmp.next;
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
            k--;
        }
        return head;
    }
}
