package cc.juddar.algorithm;

/**
 *给定两个非空链表来代表两个非负整数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class J2TwoSum {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);//没有提供无参的构造器，所以第一个元素仅仅是为了构建起一个链表，印证最后返回dump的下一个节点
        ListNode cur = dump;//TODO这一步还是没太明白，为什么要定义一个新的节点指向dump呢？我试过，直接操作dump最后结果也不对。
        int carry = 0;
        while(l1!=null || l2!=null){
            int d1=l1==null?0:l1.val;
            int d2=l2==null?0:l2.val;
            int sum = d1+d2+carry;
            carry=sum>=10?1:0;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;

        }
        if(carry==1)cur.next=new ListNode(1);//循环完了carry还有值，则需要增加一个新节点
        return dump.next;
    }
}