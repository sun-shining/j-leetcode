package cc.juddar.algorithm;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 * {@link J23}
 *
 * @Author dasongju
 * @Date 2021/2/1 17:26
 */
public class J21 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode result = merge2SortedList(node1, node2);
        assert result != null;
        J23.printListNodeItem(result);
    }

    private static ListNode merge2SortedList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val <= node2.val) {
            node1.next = merge2SortedList(node1.next, node2);
            return node1;
        }
        node2.next = merge2SortedList(node1, node2.next);
        return node2;
    }

    /**
     *  骚操作要少学,踏踏实实理解递归吧先
     **/
    private static ListNode merge2SortedList2(ListNode node1, ListNode node2) {
        if (node1 == null || (node2 != null && node1.val > node2.val)) {
            ListNode t = node1;
            node1 = node2;
            node2 = t;
        }
        if (node1 != null) {
            node1.next = merge2SortedList2(node1.next, node2);
        }
        return node1;
    }
}
