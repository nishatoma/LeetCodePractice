package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC761 {
    public String makeLargestSpecial(String s) {
        // Basically, the idea that every special string
        // must start with 1 and end with zero to satisfy its
        // properties . this way, we can recursively add 1 + our recursion
        // + 0 and build up the answer and add it to a list
        // then sort the list, and simply merge all substrings together..
        // O(N^2) total runtime
        int left = 0;
        StringBuilder sb = new StringBuilder();
        // Keep track whether a substring is 'balanced' aka special
        int count = 0;
        // Build a result list
        List<String> list = new ArrayList<>();
        // Iterate
        for (int right = 0; right < s.length(); ++right) {
            if (s.charAt(right) == '1') {
                ++count;
            } else {
                --count;
            }
            // Here check if count is zero.
            if (count == 0) {
                // If that's the case, then we have a balanced string so far,
                // So, add a 1 + Middle part of our string + 0 to the result list
                sb.append("1");
                sb.append(makeLargestSpecial(s.substring(left + 1, right)));
                sb.append("0");
                list.add(sb.toString());
                // Update window
                left = right + 1;
                // Make sure to set this SB to empty since we are re-using during for loop
                sb.setLength(0);
            }
        }
        // At teh end, sort our list
        Collections.sort(list, Collections.reverseOrder());
        // Return merged list
        return String.join("", list);
    }
}
