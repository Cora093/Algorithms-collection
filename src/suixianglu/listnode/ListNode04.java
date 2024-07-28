package suixianglu.listnode;

import structure.ListNode;

public class ListNode04 {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);

        System.out.println(head);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = head;
        ListNode r = head.next;
        ListNode temp;
        l.next = null;
        while (r != null) {
            temp = r.next;
            r.next = l;
            l = r;
            r = temp;
        }
        return l;
    }
}
