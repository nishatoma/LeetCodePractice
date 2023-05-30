package tries;

import java.util.*;

public class LC820 {
    public int minimumLengthEncoding(String[] words) {
        // Idea is to basically build a suffix tree where we insert words
        // in reverse order
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();

        for (String word : new HashSet<>(Arrays.asList(words))) {
            TrieNode curr = root;

            for (int i = word.length() - 1; i >= 0; --i) {
                char j = word.charAt(i);
                if (!curr.next.containsKey(j)) {
                    curr.next.put(j, new TrieNode());
                }
                curr = curr.next.get(j);
            }
            curr.depth = word.length() + 1;
            leaves.add(curr);
        }

        int res = 0;
        for (TrieNode leaf : leaves) {
            if (leaf.next.isEmpty()) {
                res += leaf.depth;
            }
        }

        return res;
    }

    class TrieNode {
        Map<Character, TrieNode> next = new HashMap<>();
        int depth;
    }
}
