package backtracking;

import java.util.ArrayList;
import java.util.List;

class PalindromicPartitioning_131 {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, result, new ArrayList<>());
        return result;
    }


    static void dfs(String s, int idx, List<List<String>> res, List<String> combo) {
        if (idx >= s.length()) {
            res.add(new ArrayList<>(combo));
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                String snippet = s.substring(idx, i + 1);
                combo.add(snippet);
                dfs(s, i + 1, res, combo);
                combo.remove(combo.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String str, int start, int end) {

        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

}
