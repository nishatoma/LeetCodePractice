package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1233 {
    public List<String> removeSubfolders(String[] folder) {
        // Get trie first
        Trie root = new Trie();

        // For each folder, add to the trie
        for (String f : folder) {
            root.insert(f);
        }

        // Go through the folders again and add to result array
        List<String> parents = new ArrayList<>();
        for (String f : folder) {
            root.addParentFolder(f, parents);
        }
        return parents;
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String message) {
            TrieNode curr = this.root;
            // Split first
            String[] folders = message.split("/");
            for (String folder : folders) {
                if (!curr.edges.containsKey(folder)) {
                    curr.edges.put(folder, new TrieNode());
                }
                curr = curr.edges.get(folder);
            }
            curr.isWord = true;
        }

        public void addParentFolder(String message, List<String> parents) {
            // Idea is that if we encounter a word
            // in the middle of message, then we have a parent!
            String[] folders = message.split("/");
            TrieNode curr = root;
            // Boolean to recognize its a parent
            boolean isParent = true;
            for (int i = 0; i < folders.length; ++i) {
                String folder = folders[i];
                if (curr.isWord && i < folders.length) {
                    isParent = false;
                    break;
                }
                curr = curr.edges.get(folder);
            }
            if (isParent) {
                parents.add(message);
            }
        }
    }

    public class TrieNode {
        Map<String, TrieNode> edges;
        boolean isWord;

        public TrieNode() {
            this.edges = new HashMap<>();
            this.isWord = false;
        }
    }
}
