package twopointers;

public class Leetcode_633 {

    public boolean judgeSquareSum(int c) {
        if (c == 1) return true;
        long lo = 0, hi = (long) Math.sqrt(c);
        while (lo <= hi) {
            long res = lo * lo + hi * hi;
            if (res == c) return true;
            if (res < c) ++lo;
            else --hi;
        }
        return false;
    }
}
