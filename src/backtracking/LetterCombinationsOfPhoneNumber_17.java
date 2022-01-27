package backtracking;

import java.util.LinkedList;
import java.util.List;

class LetterCombinationsOfPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();

        if (digits.isEmpty()) {
            return ans;
        }

        ans.add("");

        String[] map = new String[]{"0", "1", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            
            int n = ans.size();
            int c = digits.charAt(i) - '0';

            while (n-- != 0) {

                String combo = ans.remove();

                for (char chr : map[c].toCharArray()) {
                    ans.add(combo + chr);
                }
            }
        }
        return ans;
    }
}
