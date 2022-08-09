package tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RemoveSubFoldersFromFileSystem_1233 {

    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            // Trie solution

            // Init new Trie
            Trie root = new Trie();

            for (int i = 0; i < folder.length; ++i) {
                // Get copy trie
                Trie t = root;
                // for each char
                for (char c : folder[i].toCharArray()) {
                    // Get index
                    int idx = c == '/' ? 26 : c - 'a';
                    // If null
                    if (t.sub[idx] == null) {
                        t.sub[idx] = new Trie();
                    }
                    t = t.sub[idx];
                }
                // update index
                t.index = i;
            }

            return bfs(root, folder);
        }

        private class Trie {
            private Trie[] sub;
            private int index;

            public Trie() {
                this.sub = new Trie[27];
                this.index = -1;
            }
        }

        private List<String> bfs(Trie root, String[] folder) {
            // Init answer
            List<String> res = new ArrayList<>();
            // Init Queue
            Deque<Trie> q = new ArrayDeque<>();
            q.offer(root);

            while (!q.isEmpty()) {
                // Poll
                root = q.poll();
                // Check index
                // Found a parent folder
                if (root.index >= 0) {
                    res.add(folder[root.index]);
                }

                // Iterate over the rest of the indices
                for (int i = 0; i < 27; ++i) {
                    // Not yet found all parent folders
                    if (root.sub[i] != null && !(i == 26 && root.index >= 0)) {
                        q.offer(root.sub[i]);
                    }
                }
            }

            return res;
        }
    }
}
