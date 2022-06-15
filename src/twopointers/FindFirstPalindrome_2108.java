package twopointers;

public class FindFirstPalindrome_2108 {
    public String firstPalindrome(String[] words) {

        String res = "";
        outer:
        for (String word : words) {
            for (int i = 0, j = word.length() - 1; i <= j; ) {
                if (word.charAt(i++) != word.charAt(j--)) {
                    continue outer;
                }
            }
            return word;
        }
        return res;
    }
}
