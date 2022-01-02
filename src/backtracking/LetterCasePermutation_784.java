package backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String s) {
        // Get a queue to store our results
        LinkedList<String> perms = new LinkedList<>();
        perms.add(s);
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If it's a letter, find all permutations of the word
            if (Character.isLetter(c)) {
                int size = perms.size();

                while (size-- > 0) {
                    String word = perms.poll();
                    String left = word.substring(0, i);
                    String right = word.substring(i + 1, n);
                    perms.add(left + Character.toLowerCase(c) + right);
                    perms.add(left + Character.toUpperCase(c) + right);
                }
            }
        }
        return perms;
    }
}
