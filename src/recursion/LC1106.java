package recursion;

public class LC1106 {
    public boolean parseBoolExpr(String expression) {
        return parse(expression, 0, expression.length());
    }

    // Idea behind the recursion is to keep parsing
    // Until we reach 1 character max, then expand outwards and keep
    // applying the | & and ! conditions to our recursion output..
    private boolean parse(String str, int lo, int hi) {
        // Base case is that we have just 1 character!
        char c = str.charAt(lo);
        // Compare lo and hi, if we have 1 char, return true if that char is 't'
        if (hi - lo == 1) {
            return c == 't';
        }
        // Otherwise, initialize a current epxression we
        // work off of as a base boolean
        boolean ans = c == '&';
        // Keep levels to check if we have a valid sub expression
        int level = 0;
        // Now move through the rest of the string
        // The start variable just helps us find the start of the next sub
        // expression.
        // The reason we choose i = lo + 2 is because at each operator,
        // We know there is gonna be a paranthesis, then another expression..
        for (int i = lo + 2, start = i; i < hi; ++i) {
            // Get the current character at this index
            char c2 = str.charAt(i);
            // Check our level, and if we have reached ')' or ','
            // That means we can recurse on that sub-expression
            if (level == 0 && (c2 == ',' || c2 == ')')) {
                // If that's the case, we can recurse now!
                // if the character at i is ',' or ')' then that means
                // we can treat it as the next 'hi' upper bound. Because
                // We only want to parse the expression between lo and hi - 1, right?
                boolean curr = parse(str, start, i);
                // Update our starting index to be i + 1
                // Because we want to ignore the previous expression obviously in our next recursive
                // call
                start = i + 1;
                // Now check the value of curr, and depending on our original 'c'
                // Character at the left, rememeber? The parent operator!!
                // we can either:
                // 1) negate
                if (c == '!') {
                    ans = !curr;
                } else if (c == '&') {
                    // 2) and the result
                    ans &= curr;
                } else {
                    // 3) OR the result
                    ans |= curr;
                }
            }
            // Otherwise, if in here we see a '(' or
            // a ')' then we increment/decrement level..
            if (c2 == '(') {
                ++level;
            }
            if (c2 == ')') {
                --level;
            }
        }
        return ans;
    }
}
