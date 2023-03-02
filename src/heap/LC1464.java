package heap;

public class LC1464 {
    public int maxProduct(int[] nums) {

        int max1 = -1;
        int max2 = -1;
        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        return (max2 - 1) * (max1 - 1);
    }

    // PQ solution
    // public int maxProduct(int[] nums) {

    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for (int n : nums) {
    //         pq.offer(n - 1);
    //         if (pq.size() > 2) {
    //             pq.poll();
    //         }
    //     }
    //     return pq.poll() * pq.poll();
    // }
}
