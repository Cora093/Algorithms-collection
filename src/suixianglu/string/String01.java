package suixianglu.string;

import org.junit.jupiter.api.Test;

public class String01 {
    @Test
    public void test() {
        String s = "hello";
        char[] chars = s.toCharArray();
        System.out.println(chars);
        reverseString(chars);
        System.out.println(chars);
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }
}
