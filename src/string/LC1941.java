package string;

public class LC1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int res = count[s.charAt(0) - 'a'];

        for (int i = 0; i < 26; ++i) {
            if (count[i] != res && count[i] > 0) return false;
        }

        return true;
    }
}
