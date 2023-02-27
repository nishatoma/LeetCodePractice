package tries;

import java.util.*;

public class LC1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        // Sort the products array to maintain lexographical order
        // O(N*LOG(N))
        Arrays.sort(products);
        // For each product, add it to Trie
        // If products length is n
        // and each product has length m,
        // Then run time for this for loop is
        // O(N*M)
        for (String product : products) {
            trie.insert(product);
        }
        // Make a list for result
        List<List<String>> res = new ArrayList<>();
        // Iterate over the root edges
        TrieNode curr = trie.root;
        // O(L*X) where X is the length of suggestions
        // for each character.
        for (char c : searchWord.toCharArray()) {
            // get the suggestions list
            if (curr != null) {
                curr = curr.edges.get(c);
            }
            res.add(curr == null ? Arrays.asList() : curr.suggestions);
        }
        return res;
    }

    class TrieNode {
        Map<Character, TrieNode> edges;
        boolean isWord;
        List<String> suggestions;


        public TrieNode() {
            this.edges = new HashMap<>();
            this.isWord = false;
            suggestions = new ArrayList<>();
        }
    }

    class Trie {

        static final int MAX = 3;
        TrieNode root;


        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = this.root;
            for (char c : word.toCharArray()) {
                if (!curr.edges.containsKey(c)) {
                    // Then add
                    curr.edges.put(c, new TrieNode());
                }
                // Update current
                curr = curr.edges.get(c);
                // Also add to suggestions
                if (curr.suggestions.size() < MAX) {
                    curr.suggestions.add(word);
                }
            }
            // In the end, this trie node is a word
            curr.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = this.root;
            for (char c : word.toCharArray()) {
                if (!curr.edges.containsKey(c)) {
                    return false;
                }
                curr = curr.edges.get(c);
            }
            return curr.isWord;
        }
    }
}
