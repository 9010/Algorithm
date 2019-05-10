package cn.com.self;

import java.util.LinkedList;
import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * 2019.5.10 zx
 * 自己写的冒泡排序，时间复杂度太高了，网上最优解是递归
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists tmp = new MergeTwoSortedLists();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode result = tmp.mergeTwoLists(node1, node2);
        while(result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    //根据递归修改的算法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode result, head;
        if (l1.val < l2.val){
            result = l1;
            head = l1;
            l1 = l1.next;
        }
        else {
            result = l2;
            head = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            head.next = l1;
        }
        else if (l2 != null){
            head.next = l2;
        }

        return result;
    }

    /* 采用递归的算法..
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    */

    /* 自写的冒泡排序，相当差的算法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null){
            return l2;
        }
        else if (l2 == null && l1 != null){
            return l1;
        }
        else if (l1 == null && l2 == null){
            return null;
        }
        List<ListNode> tmp = new LinkedList<>();
        ListNode change;
        while (l1 != null){
            tmp.add(l1);
            l1 =l1.next;
        }
        while (l2 != null){
            tmp.add(l2);
            l2 = l2.next;
        }

        for(int i = 0; i < tmp.size() - 1; i++){
            for(int j = 0; j < tmp.size() - 1; j++) {
                if (tmp.get(j).val > tmp.get(j + 1).val) {
                    change = tmp.get(j);
                    tmp.set(j, tmp.get(j + 1));
                    tmp.set(j + 1, change);
                }
            }
        }

        for(int i = 0; i < tmp.size() - 1; i++){
            tmp.get(i).next = tmp.get(i + 1);
        }
        tmp.get(tmp.size() - 1).next = null;

        return tmp.get(0);
    }
    */
}
