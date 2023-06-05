package string;

public class LC1370 {
    public String sortString(String s) {
        // Basically make a character count similar to map and alternate
        int[] count = new int[26];
        int n = s.length();
        // add to char count
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        while (ans.length() < n) {
            add(count, ans, true);
            add(count, ans, false);
        }
        return ans.toString();
    }

    private void add(int[] count, StringBuilder ans, boolean asc) {
        for (int i = 0; i < 26; ++i) {
            int j = asc ? i : 25 - i;

            if (count[j]-- > 0) {
                ans.append((char) (j + 'a'));
            }
        }
    }
}
