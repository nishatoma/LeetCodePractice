package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC995A {
    public int minKBitFlips(int[] nums, int K) {
        int n = nums.length, flipped = 0, res = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (i >= K) flipped ^= q.poll();
            if (flipped == nums[i]) {
                if (i + K > nums.length) return -1;
                q.offer(1);
                flipped ^= 1;
                res++;
            } else {
                q.offer(0);
            }

        }
        return res;
    }
}
