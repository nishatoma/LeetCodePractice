package twopointers;

public class ShortestDistanceOfACharacter_821 {
    public int[] shortestToChar(String s, char c) {
        // Perform a two-pass, one going from left,
        // one going from right!!
        int n = s.length(); int pos = -n;
        // Get result array
        int[] res = new int[n];
        // Go first pass from left to right
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) pos = i;
            res[i] = i - pos;
        }
        // Go for second pass
        for (int i = pos - 1; i >= 0; --i) {
            if (s.charAt(i) == c) pos = i;
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}
