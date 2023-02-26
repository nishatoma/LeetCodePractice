package graph;

public class LC959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] map = new boolean[n * 3][n * 3];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '/') {
                    map[3*i][3*j+2] = true;
                    map[3*i+1][3*j+1] = true;
                    map[3*i+2][3*j] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    map[3*i][3*j] = true;
                    map[3*i+1][3*j+1] = true;
                    map[3*i+2][3*j+2] = true;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 3*n; ++i) {
            for (int j = 0; j < 3*n; ++j) {
                if (!map[i][j])
                    res += (dfs(i, j, map) > 0 ? 1 : 0);
            }
        }
        return res;
    }

    private int dfs(int i, int j, boolean[][] map) {
        if (Math.min(i, j) < 0 || Math.max(i, j) >= map.length || map[i][j]) {
            return 0;
        }
        map[i][j] = true;
        return 1 + dfs(i + 1, j, map)
            + dfs(i, j + 1, map)
            + dfs(i - 1, j, map)
            + dfs(i, j - 1, map);
    }
}
