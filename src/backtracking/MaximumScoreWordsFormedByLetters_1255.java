package backtracking;

public class MaximumScoreWordsFormedByLetters_1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // If non-valid input
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0)
            return 0;

        // Keep an array for letter frequency;
        int[] count = new int[score.length];

        // Count frequency of each character.
        // this will help us find which words we can form
        for (char c : letters) {
            count[c - 'a']++;
        }

        return dfs(words, score, count, 0);
    }

    private int dfs(String[] words, int[] scores, int[] count, int idx) {
        int res = 0;

        for (int i = idx; i < words.length; ++i) {
            int score = 0;
            boolean isValid = true;

            for (char c : words[i].toCharArray()) {
                score += scores[c - 'a'];
                count[c - 'a']--;
                if (count[c - 'a'] < 0) isValid = false;
            }

            // if valid, keep adding the score to the max
            // and iterate over the next word.
            if (isValid) {
                // Find the score of the next word as well
                score += dfs(words, scores, count, i + 1);
                // Update the global maxima
                res = Math.max(score, res);
            }

            // backtrack
            for (char c : words[i].toCharArray()) {
                // re-increase the count for the next word
                count[c - 'a']++;
            }
        }

        return res;
    }
}
