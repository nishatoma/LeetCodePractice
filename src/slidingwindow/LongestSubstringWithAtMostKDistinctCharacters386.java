package slidingwindow;

public class LongestSubstringWithAtMostKDistinctCharacters386 {

    /**
     * @param str: A string
     * @param k:   An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        // write your code here
        int l = 0;
        int res = 0;
        int[] map = new int[256];
        int d = 0;
        int n = str.length();

        for (int r = 0; r < n; ++r) {
            if (map[str.charAt(r)] == 0) d++;
            map[str.charAt(r)]++;

            while (l < n && d > k) {
                map[str.charAt(l)]--;
                if (map[str.charAt(l++)] == 0) d--;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
