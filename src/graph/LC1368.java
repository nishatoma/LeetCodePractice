package graph;

import java.util.PriorityQueue;

public class LC1368 {

    record Cell(int row, int col, int cost) {}

    public int minCost(int[][] grid) {
        int maxRows = grid.length, maxCols = grid[0].length;
        int targetRow = maxRows - 1, targetCol = maxCols - 1;

        boolean[][] visited = new boolean[maxRows][maxCols];

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pq.add(new Cell(0, 0, 0));

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int cost = curr.cost;
            // Mark as visited
            visited[row][col] = true;
            // Found the last cell
            if (row == targetRow && col == targetCol) {
                return cost;
            }

            // Traverse the neighbours
            if (col + 1 < maxCols && !visited[row][col + 1]) {
                pq.add(new Cell(row, col + 1, (grid[row][col] == 1 ? 0 : 1) + cost));
            }

            if (col - 1 > -1 && !visited[row][col - 1]) {
                pq.add(new Cell(row, col - 1, (grid[row][col] == 2 ? 0 : 1) + cost));
            }

            if (row + 1 < maxRows && !visited[row + 1][col]) {
                pq.add(new Cell(row + 1, col, (grid[row][col] == 3 ? 0 : 1) + cost));
            }

            if (row - 1 > -1 && !visited[row - 1][col]) {
                pq.add(new Cell(row - 1, col, (grid[row][col] == 4 ? 0 : 1) + cost));
            }
        }

        return 0;
    }
}
