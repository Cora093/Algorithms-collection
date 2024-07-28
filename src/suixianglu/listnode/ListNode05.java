package suixianglu.listnode;

import structure.ListNode;

public class ListNode05 {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);

        System.out.println(head);
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        // 循环条件是确保后面还有两个节点需要交换
        while (pre.next != null && pre.next.next != null) {
            ListNode l = pre.next;
            ListNode r = pre.next.next;
            pre.next = r;
            l.next = r.next;
            r.next = l;
            pre = l;
        }
        return preHead.next;
    }
}
