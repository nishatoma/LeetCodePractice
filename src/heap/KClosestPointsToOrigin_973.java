package heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    // O(N Log(k))
    public int[][] kClosest(int[][] points, int k) {
        // Keep sorted points according to their distance from (0,0)
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> getDistOrigin(b) - getDistOrigin(a));
        // For each point, add to q
        for (int[] point : points) {
            q.offer(point);
            // At most, q size will be k
            if (q.size() > k) q.poll();
        }
        // Result array
        int[][] res = new int[k][2];
        // Add all the elements in the queue (Sorted)
        while (k-- != 0) {
            res[k] = q.poll();
        }
        return res;
    }

    // Get squared distance from origin
    private int getDistOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
