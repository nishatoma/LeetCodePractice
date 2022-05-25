package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String s) {

        List<String> res = new ArrayList<>();

        dfs(res, 0, s.toCharArray());

        return res;
    }

    private void dfs(List<String> res, int i, char[] characters) {
        if (i == characters.length) {
            res.add (new String(characters));
            return;
        }

        if (Character.isLetter(characters[i])) {
            // Explore if upper case then backtrack
            if (Character.isUpperCase(characters[i])) {
                // Make character a lower case
                characters[i] = Character.toLowerCase(characters[i]);
                // delve in decision tree
                dfs(res, i + 1, characters);
                // backtrack
                characters[i] = Character.toUpperCase(characters[i]);
            } else {
                // Same with lower case, make it upper case
                characters[i] = Character.toUpperCase(characters[i]);
                // delve more in the recursion tree
                dfs(res, i + 1, characters);
                // backtrack
                characters[i] = Character.toLowerCase(characters[i]);
            }
        }
        // The case where we have a digit
        // Just move on to the next character
        dfs(res, i + 1, characters);
    }
}
