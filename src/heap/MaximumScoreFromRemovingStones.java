package heap;

import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {

    public int maximumScore(int a, int b, int c) {
        // Max Heap
        PriorityQueue<Integer> q = new PriorityQueue<>((num1, num2) -> num2 - num1);
        q.offer(a);
        q.offer(b);
        q.offer(c);
        int score = 0;
        while (q.size() > 1) {
            int n1 = q.poll();
            int n2 = q.poll();
            n1--;
            n2--;
            score++;
            if (n1 != 0) q.offer(n1);
            if (n2 != 0) q.offer(n2);
        }
        return score;
    }
}
