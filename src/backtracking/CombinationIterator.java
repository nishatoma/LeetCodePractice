package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    // Store the combinations in this array
    List<String> list = new ArrayList<>();
    // offset to access the next combinations
    private int offset = 0;

    public CombinationIterator(String characters, int len) {
        // generate a list of all combinations
        // using backtracking.
        dfs(characters, 0, len, this.list, new StringBuilder());
    }

    // Gets the next combination from
    // the list of combinations
    public String next() {
        // Get the next combo via offset
        return this.list.get(offset++);
    }

    // Determines whether we have a next combo
    public boolean hasNext() {
        // use the offset to see if we have another combo or not.
        return offset < this.list.size();
    }

    private void dfs(String chars, int i, int len, List<String> list, StringBuilder sb) {
        if (sb.length() == len) {
            list.add(sb.toString());
            return;
        }

        for (int idx = i; idx < chars.length(); ++idx) {
            sb.append(chars.charAt(idx));
            dfs(chars, idx + 1, len, list, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
