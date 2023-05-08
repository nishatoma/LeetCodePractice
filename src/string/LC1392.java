package string;

public class LC1392 {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lp = new int[n];
        int left = 0;
        for (int right = 1; right < n; ) {
            if (s.charAt(right) == s.charAt(left)) {
                ++left;
                lp[right] = left;
                ++right;
            } else {
                // Check if index advanced, if so, reset it
                if (left != 0) {
                    left = lp[left - 1];
                } else {
                    // just move on
                    ++right;
                }
            }
        }
        return s.substring(0, lp[n - 1]);
    }
}
