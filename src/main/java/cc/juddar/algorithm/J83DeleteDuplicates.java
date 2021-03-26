package cc.juddar.algorithm;

/**
 * 删除排序链表中的重复元素
 *
 * @Author dasongju
 * @Date 2021/3/26 15:12
 */
public class J83DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(3);
        ListNode head2 = new ListNode(1, head3);
        ListNode head = new ListNode(1, head2);
        head3.next = head4;
        head4.next = head5;
        ListNode listNode = deleteDuplicates(head);
        System.out.println("listNode = " + listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
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
}


