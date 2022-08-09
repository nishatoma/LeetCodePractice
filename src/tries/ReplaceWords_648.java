package tries;

import java.util.List;

public class ReplaceWords_648 {

    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            // Get tokens
            String[] tokens = sentence.split(" ");
            TrieNode trie = buildTrie(dict);
            return replaceWords(tokens, trie);
        }

        // Replace words given token and root
        private String replaceWords(String[] tokens, TrieNode root) {
            StringBuilder sb = new StringBuilder();

            for (String token : tokens) {
                sb.append(getShortestReplacement(token, root));
                sb.append(" ");
            }

            return sb.substring(0, sb.length() - 1);
        }

        private String getShortestReplacement(String token, final TrieNode root) {
            TrieNode temp = root;
            StringBuilder sb = new StringBuilder();
            // For each char in our word
            for (char c : token.toCharArray()) {
                sb.append(c);
                if (temp.children[c - 'a'] != null) {
                    if (temp.children[c - 'a'].isWord) {
                        return sb.toString();
                    }
                    // Not a complete word yet, continue to next level
                    temp = temp.children[c - 'a'];
                } else {
                    // Otherwise, we already have the shortest string
                    return token;
                }
            }
            return token;
        }

        // Build trie/dictionary
        private TrieNode buildTrie(List<String> dict) {
            TrieNode node = new TrieNode(' ');
            // For each word
            for (String word : dict) {
                TrieNode temp = node;
                for (char c : word.toCharArray()) {
                    if (temp.children[c - 'a'] == null) {
                        temp.children[c - 'a'] = new TrieNode(c);
                    }
                    temp = temp.children[c - 'a'];
                }
                temp.isWord = true;
            }
            return node;
        }

        // Trie class node
        private class TrieNode {
            char val;
            TrieNode[] children;
            boolean isWord;

            public TrieNode(char val) {
                this.val = val;
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }
    }
}
