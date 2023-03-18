package dfs;

import java.util.ArrayList;
import java.util.List;

public class LC386 {
    public List<Integer> lexicalOrder(int n) {
        // Idea is pretty simple, just use DFS
        // to keep exploring the numbers
        // that start with a 1, then a 2, etc..
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        } else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                // We are just checking if the
                // cur * 10 + i is > n
                // If it is, then we can't explore it
                if (cur > (n - i) / 10) {
                    return;
                }
                // Otherwise, DFS that number
                dfs(cur * 10 + i, n, res);
            }
        }

    }
}
