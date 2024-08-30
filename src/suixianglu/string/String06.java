package suixianglu.string;

import org.junit.jupiter.api.Test;

public class String06 {
    @Test
    public void test() {
        String haystack = "aabaabaaf";
        String needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i) ) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String needle) {
        int j = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i) ) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

}
