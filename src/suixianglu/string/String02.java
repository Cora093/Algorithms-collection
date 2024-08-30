package suixianglu.string;

import org.junit.jupiter.api.Test;

public class String02 {
    @Test
    public void test() {
        String s = "abcdefg";
        int k = 2;
        System.out.println(s);
        System.out.println(reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i += 2 * k) {
            int rest = sc.length - i;
            if (rest < k) {
                // 剩余字符小于k，全部反转
                reverse(sc, i, sc.length - 1);
            } else {
                // 剩余字符大于等于k，反转前k个
                reverse(sc, i, i + k - 1);
            }
        }
        return new String(sc);
    }

    private void reverse(char[] s, int l, int r) {
        if (s == null || s.length == 0) {
            return;
        }
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }
}
