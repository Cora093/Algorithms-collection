package suixianglu.hash;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Hash04 {
    @Test
    public void test() {
        int n = 19;
        System.out.println(isHappy(n));
        System.out.println(isHappy2(n));
        n = 2;
        System.out.println(isHappy(n));
        System.out.println(isHappy2(n));
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        // set存储
        HashSet<Integer> integers = new HashSet<>();
        integers.add(n);
        while (true) {
            n = getNext(n);
            if (n == 1) {
                return true;
            }
            if (integers.contains(n)) {
                return false;
            }
            integers.add(n);
        }
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int cur = n % 10;
            n = n / 10;
            sum = sum + cur * cur;
        }
        return sum;
    }

    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        while (true) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }
        }
    }
}
