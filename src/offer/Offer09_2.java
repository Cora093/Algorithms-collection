package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个队列实现一个后入先出（LIFO）的栈
 */
public class Offer09_2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    static class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.offer(x);
            } else {
                queue1.offer(x);
            }
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            } else {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
        }

        public int top() {
            if (empty()) {
                return -1;
            }
            int res;
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                res = queue2.poll();
                queue1.offer(res);
            } else {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                res = queue1.poll();
                queue2.offer(res);
            }
            return res;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
