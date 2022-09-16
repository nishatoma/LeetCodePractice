package slidingwindow;

public class NumberOfSubstringsWithAllThreeChars_1358 {

    public int numberOfSubstrings(String s) {
        int[] charCount = new int[3];

        int n = s.length();
        int res = 0;
        int l = 0;

        for (int r = 0; r < n; ++r) {
            // Increase count
            ++charCount[s.charAt(r) - 'a'];
            // Check condition
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                --charCount[s.charAt(l++) - 'a'];
            }
            res += l;
        }

        return res;
    }
}
