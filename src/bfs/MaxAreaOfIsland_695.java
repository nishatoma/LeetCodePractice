package bfs;

public class MaxAreaOfIsland_695 {

//    public int maxAreaOfIsland(int[][] grid) {
//
//        int res = 0;
//
//        // Iterate through the island
//        for (int i = 0; i < grid.length; ++i) {
//            for (int j = 0; j < grid[0].length; ++j) {
//                if (grid[i][j] == 1) {
//                    int area = getArea(grid, i, j);
//                    res = Math.max(res, area);
//                }
//            }
//        }
//        return res;
//    }
//
//    private int getArea(int[][] grid, int r, int c) {
//        // Get all direction where we can go from row and column
//        int[] dirR = new int[]{1, 0, 0, -1};
//        int[] dirC = new int[]{0, 1, -1, 0};
//
//        // BFS approach
//        Deque<Pair<Integer,Integer>> q = new ArrayDeque<>();
//        q.offer(new Pair<>(r, c));
//
//        // Mark visited
//        grid[r][c] = 2;
//
//        int area = 1;
//        // Iterate
//        while (!q.isEmpty()) {
//            // current coordinate
//            Pair<Integer, Integer> pair = q.poll();
//            // Get all possible neighbors
//            for (int i = 0; i < 4; ++i) {
//                // could be top or bot
//                int row = pair.getKey() + dirR[i];
//                // could be left or right
//                int col = pair.getValue() + dirC[i];
//
//                // if invalid coordinates
//                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) continue;
//
//                // Otherwise, we count this area if it's not visited
//                // and if we have a 1
//                if (grid[row][col] == 1) {
//                    area++;
//                    grid[row][col] = 2;
//                    q.offer(new Pair<>(row, col));
//                }
//            }
//        }
//
//        return area;
//    }
}
