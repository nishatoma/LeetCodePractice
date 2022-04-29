package binarysearch;

import java.util.Arrays;

public class CompareStringsByFrequencyOfSmallestCharacter_1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ws = new int[words.length];
        int[] qs = new int[queries.length];

        for (int i = 0; i < ws.length; ++i) {
            ws[i] = freq(words[i]);
        }

        // Count freq for queries now
        for (int i = 0; i < qs.length; ++i) {
            qs[i] = freq(queries[i]);
        }

        int[] ans = new int[qs.length];

        Arrays.sort(ws);

        for (int i = 0; i < qs.length; ++i) {
            int lo = 0;
            int hi = ws.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (qs[i] >= ws[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            ans[i] = ws.length - lo;
        }

        return ans;
    }

    static int freq(String str) {
        int count = 1;
        char min = str.charAt(0);

        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) < min) {
                count = 1;
                min = str.charAt(i);
            } else if (min == str.charAt(i)) {
                count++;
            } else {
                continue;
            }
        }

        return count;
    }

}
