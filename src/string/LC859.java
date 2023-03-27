package string;

import java.util.HashSet;
import java.util.Set;

public class LC859 {
    public boolean buddyStrings(String s, String goal) {
        // Scenario 1)
        if (s.length() != goal.length()) {
            return false;
        }
        // Scenario 2), a == b
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set.size() < s.length();
        }
        // Scenario 3), a != b
        int[] diff = new int[2];
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff[count++ % 2] = i;
            }
        }
        return count == 2 && s.charAt(diff[0]) == goal.charAt(diff[1]) && s.charAt(diff[1]) == goal.charAt(diff[0]);
    }
}
