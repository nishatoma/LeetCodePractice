package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PlaindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        dfs(s, new ArrayList<>(), res);

        return res;
    }

    private void dfs(String s, List<String> curr, List<List<String>> res) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 1; i <= s.length(); ++i) {
            // Only back track when current string is a palindrome
            String temp = s.substring(0, i);
            if (!isPalindrome(temp)) continue;
            // Process
            curr.add(temp);
            // explore the rest of the string
            dfs(s.substring(i), curr, res);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }


    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
