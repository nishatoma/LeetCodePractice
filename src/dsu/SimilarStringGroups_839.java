package dsu;

public class SimilarStringGroups_839 {

    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        UF uf = new UF(len);
        // Iterate
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (isSimilar(strs[i], strs[j])) uf.union(i, j);
            }
        }
        return uf.size();
    }

    // Check if two strings are similar
    private boolean isSimilar(String strX, String strY) {
        if (strX.equals(strY)) return true;
        int res = 0;
        for (int i = 0; i < strX.length(); ++i) {
            if (strX.charAt(i) != strY.charAt(i) && ++res > 2) return false;
        }
        return true;
    }

    public class UF {

        int[] rank;
        int[] size;
        int[] parent;
        int n;

        public UF(int n) {
            this.rank = new int[n];
            this.size = new int[n];
            this.parent = new int[n];
            this.n = n;

            // Fill initial values
            for (int i = 0; i < n; ++i) {
                this.parent[i] = i;
                this.size[i] = 1;
                this.rank[i] = 0;
            }
        }

        // Find method by path compression
        // Finds parent of current node u
        public int find(int u) {
            if (parent[u] == u) return u;
            return parent[u] = find(parent[u]);
        }

        // Union by rank
        public void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            // If same, then we have two elements in same set
            // no need to union
            if (uParent == vParent) return;

            // Check ranking
            if (rank[uParent] > rank[vParent]) {
                // Merge uParent into the bigger vParent set
                parent[vParent] = uParent;
                size[uParent] += size[vParent];
                rank[uParent]++;
            } else {
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
                rank[vParent]++;
            }
            this.n--;
        }

        // Getters
        public int size() {
            return this.n;
        }
    }
}
