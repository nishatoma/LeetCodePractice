package tries;

public class ImplementPrefixTree_208 {

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode t = root;

            for (char c : word.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode(c);
                }
                t = t.children[c - 'a'];
            }
            // We've been through all characters, so at this level,
            // The 'word' is completed.
            t.isWord = true;
        }

        public boolean search(String word) {
            TrieNode t = root;
            // For each character, search
            for (char c : word.toCharArray()) {
                // Not a word at all
                if (t.children[c - 'a'] == null) return false;
                // Go to next level
                t = t.children[c - 'a'];
            }
            // In the end, return isWord
            return t.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode t = root;

            for (char c : prefix.toCharArray()) {
                if (t.children[c - 'a'] == null) return false;
                t = t.children[c - 'a'];
            }
            // We've reached the end of the entire prefix,
            // even if not a complete word, it's still a prefix.
            return true;
        }

        class TrieNode {
            private char val;
            private TrieNode[] children = new TrieNode[27];
            private boolean isWord;

            public TrieNode() {
            }

            public TrieNode(char val) {
                TrieNode t = new TrieNode();
                t.val = val;
            }
        }
    }
}
