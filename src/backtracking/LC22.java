package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int max = n * 2;
        generate(new StringBuilder(), max, res, 0, 0);
        return res;
    }

    private void generate(StringBuilder sb, int n, List<String> res, int left, int right) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        // Check if we have less than n / 2 pairs of parentheses!
        if (left < n / 2) {
            // Add to our string builder
            sb.append('(');
            // dfs
            generate(sb, n, res, ++left, right);
            // Backtrack
            sb.setLength(sb.length() - 1);
            --left;
        }
        // We have less ) than left ones,
        // So let's generate right parentheses
        if (right < left) {
            // add to sb
            sb.append(')');
            generate(sb, n, res, left, ++right);
            // backtrack
            sb.setLength(sb.length() - 1);
            --right;
        }
    }
}
