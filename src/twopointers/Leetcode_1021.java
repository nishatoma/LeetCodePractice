package twopointers;

public class Leetcode_1021 {

    public String removeOuterParentheses(String s) {
        // Basically, keept track of closed and open parentheses
        // Whenever they are equal, we have a valid parentheses
        // This is the counting solution
        int open = 0, close = 0, start = 0;
        // Get length of string
        int len = s.length();
        // Get an SB
        StringBuilder sb = new StringBuilder();
        // Iterate over the string
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') open++;
            else close++;
            if (open == close) {
                sb.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
