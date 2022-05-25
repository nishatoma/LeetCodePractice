package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {

        // List for result
        List<String> res = new ArrayList<>();
        // String builder to store each string=
        StringBuilder sb = new StringBuilder();
        // call dfs
        dfs(n, sb, res, 0, 0);

        return res;
    }

    private void dfs(int n, StringBuilder sb, List<String> res, int open, int close) {
        // if we reached n length
        if (sb.length() == 2 * n) {
            // just add the string to the resulting list;
            res.add(sb.toString());
            return;
        }

        // if we still have open parentheses to use,
        // just use them
        if (open < n) {
            sb.append("(");
            dfs(n, sb, res, open + 1, close);
            sb.setLength(sb.length() - 1);
        }

        // if we have too much open parentheses,
        // append closed parentheses
        if (close < open) {
            sb.append(")");
            dfs(n, sb, res, open, close + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
