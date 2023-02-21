package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC241 {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        return compute(expression, map);
    }

    private List<Integer> compute(String exp, Map<String, List<Integer>> map) {
        if (map.containsKey(exp)) {
            return map.get(exp);
        }
        // Base case, we have a digit
        List<Integer> res = new ArrayList<>();
        if (isDigit(exp)) {
            res.add(Integer.parseInt(exp));
            return res;
        }
        // Otherwise, out string is not an expression
        // So we process it
        int len = exp.length();
        for (int i = 0; i < len; ++i) {
            // Get char
            char c = exp.charAt(i);
            // Get both right and left expressions
            String prefix = exp.substring(0, i);
            String suffix = exp.substring(i + 1);
            // Process both left and right
            List<Integer> left = compute(prefix, map);
            List<Integer> right = compute(suffix, map);
            // For all elements in the both lists
            // Perform the proper operations and store result in the list..
            for (int e1 : left) {
                for (int e2 : right) {
                    if (c == '*') {
                        res.add(e1 * e2);
                    } else if (c == '-') {
                        res.add(e1 - e2);
                    } else if (c == '+') {
                        res.add(e1 + e2);
                    }
                }
            }
        }
        // Now add result to map
        map.put(exp, res);
        return res;
    }

    private boolean isDigit(String number) {
        if (number.length() == 0) return false;
        for (int i = 0; i < number.length(); ++i) {
            if (!Character.isDigit(number.charAt(i))) return false;
        }
        return true;
    }
}
