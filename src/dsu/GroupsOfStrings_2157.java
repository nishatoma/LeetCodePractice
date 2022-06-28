package dsu;

import java.util.HashMap;
import java.util.Map;

public class GroupsOfStrings_2157 {
    public int[] groupStrings(String[] words) {
        // Length of the words array
        int n = words.length;
        // Array to keep track of the bitmasks
        int[] masks = new int[n];
        // Map to track mask -> index
        Map<Integer, Integer> maskToIndex = new HashMap<>();
        // UF class to help us union connected words
        UF uf = new UF(n);

        // Start with adding bitmasks + indices
        for (int i = 0; i < n; ++i) {
            // Get the current word as a character array
            char[] chars = words[i].toCharArray();
            // Iterate over that word, max 26 chars
            for (char c : chars) {
                // Set the c-'a'th bit to 1
                masks[i] |= (1 << (c - 'a'));
            }
            // Add to hashmap
            maskToIndex.put(masks[i], i);
        }

        // Iterate over each word now, and do the replace/add/delete operations
        for (int i = 0; i < n; ++i) {
            // Union find duplicated words
            uf.union(i, maskToIndex.get(masks[i]));
            // For each character in each word
            for (char c : words[i].toCharArray()) {
                // Delete that character
                int maskWithoutCh = masks[i] ^ (1 << c - 'a');
                // See if we can find a word that is connected
                if (maskToIndex.containsKey(maskWithoutCh)) {
                    // Then union
                    uf.union(i, maskToIndex.get(maskWithoutCh));
                }
                // Do replacement operation
                for (int j = 0; j < 26; ++j) {
                    if (j == c - 'a' || (maskWithoutCh | 1 << j) == maskWithoutCh) continue;

                    int maskWithCh = maskWithoutCh | (1 << j);
                    if (maskToIndex.containsKey(maskWithCh)) {
                        // then union
                        uf.union(i, maskToIndex.get(maskWithCh));
                    }
                }
            }
        }

        return uf.getGroupSizes();
    }

    class UF {
        int[] parent;
        int[] size;
        int maxGroupSize;
        int groupSize;

        public UF(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.maxGroupSize = 1;
            this.groupSize = n;

            // Init
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        // Find + path compression
        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        // Union's two groups based on size
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            // If not in the same set already
            if (px != py) {
                // Get union by size
                if (size[px] > size[py]) {
                    this.parent[py] = px;
                    this.size[px] += size[py];
                    this.maxGroupSize = Math.max(this.maxGroupSize, this.size[px]);
                } else {
                    this.parent[px] = py;
                    this.size[py] += size[px];
                    this.maxGroupSize = Math.max(this.maxGroupSize, this.size[py]);
                }
                // groupSize total gets smaller
                this.groupSize--;
            }
        }

        // Returns the group size + biggest group size
        public int[] getGroupSizes() {
            return new int[]{this.groupSize, this.maxGroupSize};
        }
    }
}
