package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SORTracker {
    private PriorityQueue<Pair> minPq;
    private PriorityQueue<Pair> maxPq;

    public SORTracker() {
        this.minPq = new PriorityQueue<>();
        this.maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void add(String name, int score) {
        Pair pair = new Pair(score, name);
        minPq.add(pair);
        maxPq.add(minPq.poll());
    }

    public String get() {
        Pair pair = maxPq.poll();
        minPq.add(pair);
        return pair.name;
    }

    private static class Pair implements Comparable<Pair> {
        int score;
        String name;

        Pair(int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.score == o.score)
                return o.name.compareTo(this.name);
            return this.score - o.score;
        }
    }
}
