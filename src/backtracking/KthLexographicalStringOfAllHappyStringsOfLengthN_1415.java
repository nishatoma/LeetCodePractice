package backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthLexographicalStringOfAllHappyStringsOfLengthN_1415 {

    public String getHappyString(int n, int k) {
        // String builder to store the result
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        dfs(n, sb, list, k);

        if (k > list.size()) return "";

        return list.get(k - 1);
    }

    private void dfs(int n, StringBuilder sb, List<String> list, int k) {
        // we reached our limit, we simply want the kth element
        if (list.size() == k) return;

        if (n == 0) {
            // we reached string character limit, so add it
            // to the list of result
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; ++i) {
            // get the current charcter from possibilities [a, b, c]
            char c = (char) (i + 'a');
            // if the string is empty, or we have no duplicate
            // characters after one another, then add the character
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                // Add it to the string builder
                sb.append(c);
                // Explore more possibilities
                dfs(n - 1, sb, list, k);
                // backtrack
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
