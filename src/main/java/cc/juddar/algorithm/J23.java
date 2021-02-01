package cc.juddar.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 *
 * Example:
 *
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 思路1：利用分治的思路,将K个链表最终变成两个链表的合并
 * @author dasongju
 */
public class J23 {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        listNodes[0] = node1;
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        listNodes[1] = node2;
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        listNodes[2] = node3;

        ListNode node = mergeKListNode1(listNodes, 0, 2);
        printListNodeItem(node);
    }

    public static void printListNodeItem(ListNode listHead) {
        while (listHead.next != null && listHead.next.val > 0) {
            System.out.print(listHead.val + "->");
            listHead = listHead.next;
        }
        System.out.println(listHead.val);
    }

    public static ListNode mergeKListNode1(ListNode[] listNodes, int low, int high) {
        if (low == high) {
            return listNodes[low];
        }

        int middle = low + (high - low) / 2;

        return mergeTwoLists(
            mergeKListNode1(listNodes, low, middle),
            mergeKListNode1(listNodes, middle + 1, high)
        );
    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.val <= b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        }
        b.next = mergeTwoLists(a, b.next);
        return b;
    }
}
