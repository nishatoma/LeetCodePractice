package oop;

// Template class
public class UF {

    int[] rank;
    int[] size;
    int[] parent;

    public UF(int n) {
        this.rank = new int[n];
        this.size = new int[n];
        this.parent = new int[n];

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
    }

    // Getters
    public int[] getRanks() {
        return this.rank;
    }

    public int[] getParents() {
        return this.parent;
    }

    public int[] getSizes() {
        return this.size;
    }
}
