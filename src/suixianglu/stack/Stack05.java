package suixianglu.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Stack05 {
    @Test
    public void test() {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        char[] charArray = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.removeLast();
        }
        return res;
    }
}
