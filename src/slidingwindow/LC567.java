package slidingwindow;

import java.util.Arrays;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        // First, create a charcter profile map of s1 first
        int[] s1Count = new int[26];
        // Keep track of each count of all chars in s1
        for (char c : s1.toCharArray()) {
            ++s1Count[c - 'a'];
        }
        // Idea is to maintain a window size and slide it accross
        // S2, and if we meet teh same character profile, return true
        // Otherwise we will return false at the end.
        int max = s1.length();
        int n = s2.length();
        // Create a temp count to compare as we slide
        int[] slideCount = new int[26];
        for (int i = 0; i < n; ++i) {
            // increase slideCount at the current index
            ++slideCount[s2.charAt(i) - 'a'];
            // IF we are at max window size, move the window
            if (i - max >= 0) {
                // decrement left side in order to move the window
                --slideCount[s2.charAt(i - max) - 'a'];
            }
            // Compare the two profiles,
            if (Arrays.equals(s1Count, slideCount)) return true;
        }
        return false;
    }
}
