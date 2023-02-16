package string;

public class Leetcode_1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++open;
            } else if (c == ')') {
                if (open == 0) continue;
                --open;
            }
            sb.append(c);
        }

        // Result
        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; --i) {
            char c = sb.charAt(i);
            if (c == '(' && open-- > 0) continue;
            res.append(c);
        }
        return res.reverse().toString();
    }
}
