package dsu;

public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        // Init with grid
        UF uf = new UF(grid);
        // Rows and cols
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {
                    if (isCellValid(grid, i - 1, j)) uf.union(i * cols + j, (i - 1) * cols + j);
                    if (isCellValid(grid, i, j - 1)) uf.union(i * cols + j, i * cols + j - 1);
                }
            }
        }
        return uf.getMaxSize();
    }

    private boolean isCellValid(int[][] grid, int x, int y) {
        return (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1);
    }

    class UF {
        private int[] parent;
        private int[] size;
        private int maxSize;

        public UF(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            this.parent = new int[rows * cols];
            this.size = new int[rows * cols];
            this.maxSize = 0;

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (grid[i][j] == 1) {
                        this.parent[i * cols + j] = i * cols + j;
                        this.size[i * cols + j] = 1;
                        this.maxSize = 1;
                    }
                }
            }
        }

        // Find the representative of a single cell coordinate
        // in the grid
        public int find(int x) {
            if (this.parent[x] == x) return x;
            return this.parent[x] = find(this.parent[x]);
        }

        // Union position of two cells in the grid
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                if (this.size[px] > this.size[py]) {
                    this.parent[py] = px;
                    this.size[px] += this.size[py];
                    this.maxSize = Math.max(this.maxSize, this.size[px]);
                } else {
                    this.parent[px] = py;
                    this.size[py] += this.size[px];
                    this.maxSize = Math.max(this.maxSize, this.size[py]);
                }
            }
        }

        public int getMaxSize() {
            return this.maxSize;
        }
    }
}
