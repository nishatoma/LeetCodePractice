package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC1286 {
    List<String> combos;
    int index;

    public LC1286(String characters, int combinationLength) {
        combos = new ArrayList<>();
        index = 0;
        findAllCombos(characters, new StringBuilder(), 0, combinationLength, combos);
    }

    public String next() {
        return combos.get(index++);
    }

    public boolean hasNext() {
        return (index < combos.size());
    }

    private void findAllCombos(String characters, StringBuilder sb, int idx, int comboLength, List<String> res) {
        if (sb.length() == comboLength) {
            res.add(sb.toString());
            return;
        }
        // For each character, try a diff combo
        for (int i = idx; i < characters.length(); ++i) {
            sb.append(characters.charAt(i));
            // Dfs
            findAllCombos(characters, sb, i + 1, comboLength, res);
            // Backtrack
            sb.setLength(sb.length() - 1);
        }
    }
}
