package dp;

public class CountSubstringsThatDifferByOneCharacter_1638 {

    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return countSubstrings(t, s);

        int res = 0;
        int[][] dp = new int[n + 1][2];
        
        for (int i = 0; i < m; ++i) {
            int[][] temp = new int[n + 1][2];
            for (int j = 0; j < n; ++j) {
                // Let dp[i][j][0] be # of substrings
                // that are different by 0 character
                temp[j + 1][0] = (s.charAt(i) == t.charAt(j) ? dp[j][0] + 1 : 0);
                temp[j + 1][1] = (s.charAt(i) == t.charAt(j) ? dp[j][1] : dp[j][0] + 1);
                res += temp[j + 1][1];
            }
            dp = temp;
        }
        return res;
    }
}
