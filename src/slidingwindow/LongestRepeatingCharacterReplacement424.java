package slidingwindow;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement424 {


    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
        int maxFreq = 0;
        int numLettersToChange = 0;
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        int res = 0;

        for (int r = 0; r < n; ++r) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            // Get number of letters to change
            numLettersToChange = r - l + 1 - maxFreq;
            // If the number of letters to change > k, then
            // decrease the window
            if (numLettersToChange > k) {
                freq[s.charAt(l++) - 'A']--;
            }
            res = Math.max(res, r - l + 1);

        }

        return res;

    }

}
