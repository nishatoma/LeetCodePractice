package tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Words array in stentence
        // O(N) where N = lengeth of sentence
        String[] words = sentence.split(" ");

        // Instantiate trie
        Trie trie = new Trie();

        // For each word in dictionary, add to our trie
        // O(LD * M)
        // M is the number words in the dictionary
        // LD is the length of each word in dictionary
        for (String word : dictionary) {
            trie.insert(word);
        }

        // For each word in 'words' array, try and replace it with
        // its root
        // O(LW * N)
        // Where N is the length of words array
        // And LW is the length of each word in words
        for (int i = 0; i < words.length; ++i) {
            String root = trie.getRoot(words[i]);
            if (!root.isEmpty()) {
                words[i] = root;
            }
        }

        // String builder
        StringBuilder sb = new StringBuilder();
        // For each word add to sb
        // O(N) since there are N words
        for (int i = 0; i < words.length; ++i) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        // Total runtime => O(LW * N + LD * M))
        return sb.toString();
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.edges.containsKey(c)) {
                    curr.edges.put(c, new TrieNode());
                }
                curr = curr.edges.get(c);
            }
            curr.isWord = true;
            curr.word = word;
        }

        public String getRoot(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.edges.get(c);
                if (curr == null) return "";
                if (curr.isWord) {
                    return curr.word;
                }
            }
            return curr.word;
        }
    }


    class TrieNode {
        Map<Character, TrieNode> edges;
        boolean isWord;
        String word;

        public TrieNode() {
            this.edges = new HashMap<>();
            isWord = false;
            this.word = "";
        }
    }
}
