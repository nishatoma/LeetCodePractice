package string;

public class LC1781 {
    public int beautySum(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); ++i) {
            int[] count = new int[26];

            for (int j = i; j < s.length(); ++j) {
                // get hte count
                ++count[s.charAt(j) - 'a'];
                // Get beauty
                int beauty = getBeauty(count);
                // Get res
                res += beauty;
            }
        }
        return res;
    }

    private int getBeauty(int[] charCount) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < charCount.length; ++i) {
            if (charCount[i] == 0) {
                continue;
            }
            min = Math.min(min, charCount[i]);
            max = Math.max(max, charCount[i]);
        }
        return max - min;
    }
}
