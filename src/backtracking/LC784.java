package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        // make a char array
        char[] arr = s.toCharArray();
        dfs(s, 0, res, arr);
        return res;
    }

    private void dfs(String s, int idx, List<String> res, char[] arr) {
        if (idx == s.length()) {
            res.add(new String(arr));
            return;
        }
        // If the current character is a number
        // just skip it
        char c = s.charAt(idx);
        if ('0' <= c && c <= '9') {
            // Move on
            dfs(s, idx + 1, res, arr);
        } else {
            // Otherwise, make the char small
            arr[idx] = Character.toLowerCase(c);
            // Go dfs
            dfs(s, idx + 1, res, arr);
            // Make it capital
            arr[idx] = Character.toUpperCase(c);
            // Go deeper
            dfs(s, idx + 1, res, arr);
        }
    }
}
