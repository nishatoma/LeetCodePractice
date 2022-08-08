package tries;

import java.util.*;

public class SearchSuggestionsSystem_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Trie solution
        // time -> O(m*m*n + L)
        // where m is the length of the product word, n is the length
        // of the products array, and L is the length of the search word.
        Trie root = new Trie();
        // go over each product and insert them
        for (String p : products) {
            insert(p, root);
        }

        return search(searchWord, root);
    }


    private void insert(String word, Trie root) {
        Trie t = root;

        for (char c : word.toCharArray()) {

            if (t.sub[c - 'a'] == null) {
                t.sub[c - 'a'] = new Trie();
            }
            t = t.sub[c - 'a'];
            // suggestins
            t.suggestions.offer(word);
            // Sort
            Collections.sort(t.suggestions);
            // Max character
            if (t.suggestions.size() > 3) {
                // remove last
                t.suggestions.pollLast();
            }
        }
    }

    private List<List<String>> search(String word, Trie root) {
        List<List<String>> res = new ArrayList<>();

        // For each character
        for (char c : word.toCharArray()) {
            if (root != null) {
                root = root.sub[c - 'a'];
            }
            // Add the root
            res.add(root == null ? Arrays.asList() : root.suggestions);
        }

        return res;
    }

    private class Trie {
        private Trie[] sub = new Trie[26];
        private LinkedList<String> suggestions = new LinkedList<>();
    }
}
