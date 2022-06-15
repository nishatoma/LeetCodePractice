package twopointers;

public class DIStringMatch_942 {
    public int[] diStringMatch(String s) {
        int lo = 0;
        int hi = s.length();
        int[] res = new int[hi + 1];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == 'D') {
                res[i++] = hi--;
            } else {
                res[i++] = lo++;
            }
        }
        res[res.length - 1] = s.charAt(s.length() - 1) == 'D' ? hi : lo;
        return res;
    }
}
