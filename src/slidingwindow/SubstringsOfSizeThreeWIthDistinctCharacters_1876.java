package slidingwindow;

public class SubstringsOfSizeThreeWIthDistinctCharacters_1876 {

    public int countGoodSubstrings(String s) {

        int[] cnt = new int[26];
        int res = 0;
        int rep = 0;
        int n = s.length();
        int MAX = 3;

        for (int i = 0; i < n; ++i) {
            // Increase repeating char
            rep += cnt[s.charAt(i) - 'a']++ == 1 ? 1 : 0;
            // If we reach the 3rd char then we have less repeating chars..
            rep -= i >= MAX && cnt[s.charAt(i - MAX) - 'a']-- == 2 ? 1 : 0;
            // We have at least completed 3 chars with 'i >= 2'
            res += i >= 2 && rep == 0 ? 1 : 0;
        }

        return res;
    }
}
