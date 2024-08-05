package suixianglu.listnode;

import org.junit.jupiter.api.Test;
import structure.ListNode;

public class ListNode07 {
    @Test
    public void test() {
        ListNode tail = new ListNode<>(8);
        tail.next = new ListNode<>(4);
        tail.next.next = new ListNode<>(5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = tail;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = tail;
        System.out.println(getIntersectionNode(headA, headB));
        System.out.println(getIntersectionNode2(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        int lengthA = getListNodeLength(headA);
        int lengthB = getListNodeLength(headB);
        int diff = Math.abs(lengthB - lengthA);
        ListNode curA = headA;
        ListNode curB = headB;
        if (lengthB > lengthA) {
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
            while (curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
            while (curA != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
                curA = curA.next;
            }
        }
        return null;
    }

    public int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //特殊情况
        if (headA == null || headB == null) {
            return null;
        }
        ListNode PA = headA, PB = headB;
        while (PA != PB) {
            if (PA == null) {
                PA = headB;
            } else {
                PA = PA.next;
            }

            if (PB == null) {
                PB = headA;
            } else {
                PB = PB.next;
            }
        }

        return PA;
    }
}
