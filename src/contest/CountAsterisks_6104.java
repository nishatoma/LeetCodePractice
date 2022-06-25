package contest;

public class CountAsterisks_6104 {
    public int countAsterisks(String s) {
        int bar = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            // toggle
            if (c == '|') bar ^= 1;
            // if the asterisk is not between valid pair
            if (bar == 0 && c == '*') res++;
        }
        return res;
    }
}
