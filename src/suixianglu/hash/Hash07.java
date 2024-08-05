package suixianglu.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hash07 {
    @Test
    public void test() {
        Assertions.assertFalse(canConstruct("a", "b"));
        Assertions.assertFalse(canConstruct("aa", "ab"));
        Assertions.assertTrue(canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        char[] charArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        for (char c : magazineArray) {
            alphabet[c - 'a']++;
        }
        for (char c : charArray) {
            if (--alphabet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
