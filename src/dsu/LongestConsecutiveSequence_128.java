package dsu;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        // Edge case
        if (nums.length <= 1) return nums.length;
        // DSU
        UnionFind uf = new UnionFind(nums.length);
        // Map in order to map num -> index
        Map<Integer, Integer> valToIndex = new HashMap<>();
        // for each number
        for (int i = 0; i < nums.length; ++i) {
            // Already processed
            if (valToIndex.containsKey(nums[i])) continue;
            // Make use of union find to get
            // consecutive elements!!
            if (valToIndex.containsKey(nums[i] - 1)) {
                uf.union(i, valToIndex.get(nums[i] - 1));
            }

            // Same for consecutive larger numbers
            if (valToIndex.containsKey(nums[i] + 1)) {
                uf.union(i, valToIndex.get(nums[i] + 1));
            }
            // Add to map
            valToIndex.put(nums[i], i);
        }
        return uf.getSetWithLargestSize();
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.maxSize = 1;

            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        /**
         * Path compression
         **/
        private int find(int num) {
            if (parent[num] == num) return num;

            return parent[num] = find(parent[num]);
        }

        // Union by rank, highest size wins (Does not pass some test case)!!
        private void union(int u, int v) {
            int pU = find(u);
            int pV = find(v);

            // Rank by size
            if (size[pV] > size[pU]) {
                size[pV] += size[pU];
                parent[pU] = pV;
                this.maxSize = Math.max(this.maxSize, size[pV]);
            } else {
                size[pU] += size[pV];
                parent[pV] = pU;
                this.maxSize = Math.max(this.maxSize, size[pU]);
            }
        }

        // get the set with the largest size
        private int getSetWithLargestSize() {
            return this.maxSize;
        }
    }
}
