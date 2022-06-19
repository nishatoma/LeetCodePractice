package contest;

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetterinUpperAndLowerCase_2309 {
    // Total run time: O(N)
    // Total space complexity: O(N)
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c = 'z'; c >= 'a'; c--) {
            if (set.contains(c) && set.contains((char) ('A' + c - 'a'))) {
                return "" + (char) ('A' + c - 'a');
            }
        }
        return "";
    }
}
