package suixianglu.listnode;

import structure.ListNode;

public class ListNode06 {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);

        System.out.println(head);
        System.out.println(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除一个节点需要拿到它的前一个节点
        ListNode preHead = new ListNode(-1, head);
        ListNode l = preHead, r = preHead;
        // r 先走 n + 1 步
        for (int i = 0; i < n + 1; i++) {
            r = r.next;
        }
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return preHead.next;
    }
}
