package matrix;

public class LC1351 {
    public int countNegatives(int[][] grid) {
        // start at top right, then move left
        // and increment result by row size if we see a negative
        // if we see a positive, then go down one row and check again..
        // get the size
        int m = grid.length, n = grid[0].length;
        int top = 0, right = n - 1;
        // get
        // counter
        int count = 0;
        // Iterate now
        while (top < m && right >= 0) {
            // check the element
            if (grid[top][right] < 0) {
                // it's a negative, so,
                // we can take the entire row!
                count += m - top;
                // Then we move left
                --right;
            } else {
                // Otherwise, check if there is a smaller
                // element by going down a row..
                ++top;
            }
        }
        return count;
    }
}
