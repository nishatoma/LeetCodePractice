package heap;

import java.util.PriorityQueue;

public class LC973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // Sort by biggest distance, to build a max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (dist(b[0], b[1]) - dist(a[0], a[1])));
        // Go through the points
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // Fill result
        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll();
        }
        return res;
    }

    // Give us distance from origin
    private int dist(int x, int y) {
        return x * x + y * y;
    }
}
