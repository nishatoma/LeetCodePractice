package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        // character count
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            ++cnt[c - 'a'];
        }
        // Check String s
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        int max = p.length();
        // Create temp count
        int[] temp = new int[26];
        for (int i = 0; i < len; ++i) {
            // fill temp
            ++temp[s.charAt(i) - 'a'];
            // check left boundary
            if (i - max >= 0) {
                // decrement
                --temp[s.charAt(i - max) - 'a'];
            }
            // Check anagarams
            if (Arrays.equals(temp, cnt)) {
                // store start in result
                res.add(i - max + 1);
            }
        }
        return res;
    }
}
