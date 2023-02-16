package string;

public class Leetcode_1614 {
    public int maxDepth(String s) {
        int max = 0;
        int open = 0, close = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                max = Math.max(open, max);
            } else if (c == ')') {
                open--;
            }
        }
        return max;
    }
}
