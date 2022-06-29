package dsu;

public class RegionsCutBySlashes_959 {

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        // Init DSU
        DSU dsu = new DSU(N * N * 4);

        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                // Get the character
                char val = grid[i].charAt(j);

                // Check the character for different values
                if (val == '/') {
                    // Merge top+left, bottom+right
                    dsu.union(getTop(count), getLeft(count));
                    dsu.union(getRight(count), getBot(count));
                }

                // If backslash
                if (val == '\\') {
                    // Merge top + right, bottom + left
                    dsu.union(getTop(count), getRight(count));
                    dsu.union(getBot(count), getLeft(count));
                }

                // If blank, union all parts
                if (val == ' ') {
                    dsu.union(getTop(count), getBot(count));
                    dsu.union(getLeft(count), getRight(count));
                    dsu.union(getLeft(count), getTop(count));
                }

                // Check if we are not in the first row
                if (i != 0) {
                    dsu.union(getTop(count), getBot(count - N));
                }

                // Same with column
                if (j != 0) {
                    dsu.union(getLeft(count), getRight(count - 1));
                }
                count++;
            }
        }
        return dsu.getCount();
    }

    private int getTop(int N) {
        return N * 4;
    }

    private int getRight(int N) {
        return N * 4 + 1;
    }

    private int getBot(int N) {
        return N * 4 + 2;
    }

    private int getLeft(int N) {
        return N * 4 + 3;
    }

}

class DSU {
    private int[] parent;
    private int[] size;
    private int count;

    public DSU(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.count = n;

        // Init
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int x) {
        if (this.parent[x] == x) return x;
        return this.parent[x] = find(this.parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            count--;
            if (this.size[px] > this.size[py]) {
                this.parent[py] = px;
                this.size[px] += this.size[py];
            } else {
                this.parent[px] = py;
                this.size[py] += this.size[px];
            }
        }
    }

    public int getCount() {
        return this.count;
    }
}
