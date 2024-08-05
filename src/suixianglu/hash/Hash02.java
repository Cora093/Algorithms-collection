package suixianglu.hash;

import org.junit.jupiter.api.Test;

public class Hash02 {
    @Test
    public void test() {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[c1[i] - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[c2[i] - 'a']--;
            if (alphabet[c2[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
