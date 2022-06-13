package contest;

public class FairDistributionOfCookies_2305 {

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        // dfs
        return dfs(cookies, 0, k, children);
    }

    // backtracking solution. Essentially, generate all possible distributions,
    // find maximum a child can receive each distribution, then minimize it by comparing it
    // to the min. in the end, we will end up with the LOWEST UNFAIR distribution for the children.
    // Basically, minimize what we just maximized.
    private int dfs(int[] cookies, int curr, int k, int[] children) {
        int max = Integer.MIN_VALUE;
        int res = Integer.MAX_VALUE;
        if (curr == cookies.length) {
            for (int c : children) max = Math.max(max, c);
            res = Math.min(res, max);
        } else {
            for (int i = 0; i < k; ++i) {
                children[i] += cookies[curr];
                res = Math.min(res, dfs(cookies, curr + 1, k, children));
                children[i] -= cookies[curr];
            }
        }
        return res;
    }
}
