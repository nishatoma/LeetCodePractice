package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        return compute(expression, map);
    }

    private List<Integer> compute(String str, Map<String, List<Integer>> memo) {
        // Check memo first
        List<Integer> result = memo.get(str);
        // Check if not null
        if (result != null) return result;
        // Otherwise initialize the result
        result = new ArrayList<>();
        // Check base case to see if the expression is a digit
        if (isDigit(str)) {
            // Save value to result and return
            result.add(Integer.parseInt(str));
            // Return the result
            return result;
        }
        int len = str.length();
        // Otherwise, loop through the expression
        for (int i = 0; i < len; ++i) {
            // Get the ith character
            char c = str.charAt(i);
            // Check whether +, - or *
            if (c == '*' || c == '+' || c == '-') {
                // Get left half and right half
                String a = str.substring(0, i);
                String b = str.substring(i + 1);
                // Get both result lists
                List<Integer> al = compute(a, memo);
                List<Integer> bl = compute(b, memo);
                // Iterate through both lists
                for (int num1 : al) {
                    for (int num2 : bl) {
                        if (c == '*') {
                            result.add(num1 * num2);
                        } else if (c == '+') {
                            result.add(num1 + num2);
                        } else {
                            result.add(num1 - num2);
                        }
                    }
                }
            }
        }
        // Store the result in the memo
        memo.put(str, result);
        return result;
    }


    // Method to check whether a string 343 or 3+3
    // is a full digit
    private boolean isDigit(String str) {
        // Loop through
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
