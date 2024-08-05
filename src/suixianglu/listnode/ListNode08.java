package suixianglu.listnode;

import org.junit.jupiter.api.Test;
import structure.ListNode;

public class ListNode08 {
    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;
        System.out.println(detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode meet = slow;
                while (meet != head) {
                    meet = meet.next;
                    head = head.next;
                }
                return meet;
            }
        }
        return null;
    }
}
