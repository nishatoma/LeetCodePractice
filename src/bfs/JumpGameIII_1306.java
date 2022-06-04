package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        // If the starting index is the one we are looking
        // for, we can just return true here
        if (arr[start] == 0) return true;
        // Initialize Queue for BFS
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        // Go over the Queue
        while (!q.isEmpty()) {
            int curr = q.poll();
            // We found our answer
            if (arr[curr] == 0) return true;
            // We didn't find the answer?
            // Then explore hi and lo index
            int jumpHi = curr + arr[curr];
            int jumpLo = curr - arr[curr];
            // Mark as visited
            arr[curr] = -1;
            // Explore higher index
            if (jumpHi < arr.length && arr[jumpHi] > -1) {
                q.offer(jumpHi);
            }
            // Explore lower index
            if (jumpLo >= 0 && arr[jumpLo] > -1) {
                q.offer(jumpLo);
            }
        }
        return false;
    }


}
