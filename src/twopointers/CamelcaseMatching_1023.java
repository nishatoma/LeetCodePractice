package twopointers;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        for (String q : queries) {
            res.add(isValid(q.toCharArray(), pat));
        }
        return res;
    }

    // Returns true if query matches regex
    private boolean isValid(char[] arr, char[] pat) {
        int j = 0;
        for (int i = 0; i < arr.length; ++i) {
            // If the two values are the same within
            // each the q and pattern, then just keep going
            if (j < pat.length && arr[i] == pat[j]) {
                j++;
                // otherwise, if we see they are not the same,
                // check if hte query character is capitalized, if so,
                // then for sure it does not match the regex
            } else if ('A' <= arr[i] && arr[i] <= 'Z') {
                return false;
            }
        }
        return j == pat.length;
    }
}
