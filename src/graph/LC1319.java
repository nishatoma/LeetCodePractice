package graph;

public class LC1319 {
    public int makeConnected(int n, int[][] connections) {
        // find the total number of connected components and subtract 1 from it
        // For example, if we have 6 PCs, and we have 3 connected PCs,
        // we need 2 connections more in order to have all 6 PCs connected
        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int wires = n;
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int[] c : connections) {
            int p1 = findParent(c[0], parent);
            int p2 = findParent(c[1], parent);

            if (p1 != p2) {
                // union
                parent[p1] = p2;
                --wires;
            }
        }
        return wires - 1;
    }

    // We use union find with path compression in order to find the # of connected components
    private int findParent(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = findParent(parent[i], parent);
    }
}
