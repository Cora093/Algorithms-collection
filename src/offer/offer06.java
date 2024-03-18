package offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class offer06 {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        System.out.println("原链表：");
        System.out.println(head);
        System.out.println("递归打印：");
        printReverselyRecursively(head);
        System.out.println("\n非递归打印：");
        printReverselyIteratively(head);
    }

    //递归打印
    public static void printReverselyRecursively(ListNode<Integer> node) {
        if (node != null) {
            printReverselyRecursively(node.next);
            System.out.print(node.val + " ");
        } else {
            return;
        }
    }

    //非递归打印 使用栈
    public static void printReverselyIteratively(ListNode<Integer> node) {
        if (node == null) {
            return;
        } else {
            Stack<Object> stack = new Stack<>();
            while (node != null) {
                stack.push(node.val);
                node = node.next;
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}

