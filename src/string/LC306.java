package string;

import java.util.ArrayList;
import java.util.List;

public class LC306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(0, num, new ArrayList<>());
    }

    private boolean dfs(int idx, String num, List<String> res) {
        if (idx == num.length()) {
            return res.size() > 2;
        }

        // Iterate over the string
        for (int i = idx; i < num.length(); ++i) {
            // Check for zero case
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }
            // Get current num
            String curr = num.substring(idx, i + 1);
            // Check if they add up or if the list doesn't
            // have many elements anyways..
            if (res.size() < 2 || curr.equals(String.valueOf(Long.parseLong(res.get(res.size() - 1)) + Long.parseLong(res.get(res.size() - 2))))) {
                // Add to list
                res.add(curr);
                // DFS
                if (dfs(i + 1, num, res)) {
                    return true;
                }
                // Backtrack
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
