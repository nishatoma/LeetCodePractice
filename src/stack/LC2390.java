package stack;

public class LC2390 {
    public String removeStars(String s) {
        // Treat SB as a stack
        StringBuilder stack = new StringBuilder();
        // Just add characters that are not '*'
        // And remove the last character when we see a '*'
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && c == '*') {
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(c);
            }

        }
        return stack.toString();
    }
}
