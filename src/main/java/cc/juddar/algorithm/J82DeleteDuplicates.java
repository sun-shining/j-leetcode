package cc.juddar.algorithm;

/**
 * 删除排序链表中的重复元素
 *
 * @Author dasongju
 * @Date 2021/3/26 15:12
 */
public class J82DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(3);
        ListNode head6 = new ListNode(4);
        ListNode head7 = new ListNode(4);
        ListNode head8 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;
        ListNode listNode = deleteDuplicates(head);
        printListNodeItem(listNode);
    }
    // 0 1 1 2 3 3 4
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void printListNodeItem(ListNode listHead) {
        if (listHead == null) {
            return;
        }
        while (listHead.next != null && listHead.next.val > 0) {
            System.out.print(listHead.val + "->");
            listHead = listHead.next;
        }
        System.out.println(listHead.val);
    }
}


