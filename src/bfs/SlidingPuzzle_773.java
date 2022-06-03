package bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle_773 {

    public int slidingPuzzle(int[][] board) {
        // how our end state looks like
        String endPuzzle = "123450";

        StringBuilder sb = new StringBuilder();
        // Get the current state of the puzzle as a string
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                sb.append(board[i][j]);
            }
        }
        // Get string value of starting puzzle state
        String startPuzzle = sb.toString();
        // Make a 2-D array that represents what choices are possible depending on where
        // we are on the puzzle board
        // i.e when at position 0 in "012345", then we can swap with numbers
        // that are in index 1 and 3, which happen to be numbers 1 and 3 in this case.
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        // If the start puzzle matches already, no need for more calculations
        if (startPuzzle.equals(endPuzzle)) return 0;
        // Make a set for visited states
        Set<String> set = new HashSet<>();
        // Make a Queue for BFS traversal
        Deque<String> q = new ArrayDeque<>();
        q.offer(startPuzzle);
        set.add(startPuzzle);

        // Current level
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- != 0) {
                // Get current puzzle state
                String curr = q.poll();
                // If we match, return the current level
                // which represents the minimum number of steps
                // Since we are doing a level-order traversal on the number of
                // possible states
                if (curr.equals(endPuzzle)) return level;
                // Get index of zero first
                int index = curr.indexOf('0');
                // For each possible swap position for that
                // 0 position, do a number of swaps
                // and store puzzle state if possible
                // for processing next in Queue
                for (int swapIndex : dirs[index]) {
                    StringBuilder str = new StringBuilder(curr);
                    // Swap
                    str.setCharAt(index, curr.charAt(swapIndex));
                    str.setCharAt(swapIndex, curr.charAt(index));
                    // Get string value
                    String node = str.toString();
                    // Check if visited
                    if (set.contains(node)) continue;
                    set.add(node);
                    q.offer(node);
                }
            }
            level++;
        }
        return -1;
    }
}
