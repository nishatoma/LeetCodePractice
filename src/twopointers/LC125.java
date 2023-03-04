package twopointers;

public class LC125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int lo = 0, hi = s.length() - 1;
        if (hi < 1) return true;
        while (lo <= hi) {
            char c1 = s.charAt(lo);
            char c2 = s.charAt(hi);
            if (!Character.isLetterOrDigit(c1)) {
                ++lo;
            } else if (!Character.isLetterOrDigit(c2)) {
                --hi;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                ++lo;
                --hi;
            }
        }

        return true;
    }
}
