package twopointers;

public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;
        int res = 0;
        int preRun = 0;
        int curRun = 1;
        int n = s.length();

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curRun++;
            } else {
                preRun = curRun;
                curRun = 1;
            }
            if (preRun >= curRun) res++;
        }
        return res;
    }
}
