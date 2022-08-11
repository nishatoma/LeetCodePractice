package tries;

import java.util.*;

public class ShortEncodingOfWords_820 {

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie root = new Trie();
        // Count leaves
        List<Trie> leaves = new ArrayList<>();

        for (String w : new HashSet<>(Arrays.asList(words))) {
            Trie curr = root;

            for (int i = w.length() - 1; i >= 0; --i) {
                char c = w.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            // Increased depth after we've added the word
            curr.depth += w.length() + 1;
            leaves.add(curr);
        }

        // Now go through leaves and add up the depths
        // which represent the length of each word + "#" character
        for (Trie leaf : leaves) {
            // Only if it's an actual leaf node aka no children
            if (leaf.children.isEmpty()) {
                res += leaf.depth;
            }
        }

        return res;
    }

    private class Trie {
        private Map<Character, Trie> children;
        private int depth;

        public Trie() {
            children = new HashMap<>();
            depth = 0;
        }
    }
}
