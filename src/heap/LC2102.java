package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC2102 {

    PriorityQueue<Location> maxQ;
    PriorityQueue<Location> minQ;

    public LC2102() {
        maxQ = new PriorityQueue<>();
        minQ = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void add(String name, int score) {
        Location location = new Location(name, score);
        minQ.offer(location);
        maxQ.offer(minQ.poll());
    }

    public String get() {
        minQ.offer(maxQ.peek());
        return maxQ.poll().name;
    }


    class Location implements Comparable<Location> {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Location other) {
            if (this.score == other.score) {
                return this.name.compareTo(other.name);
            }
            return other.score - this.score;
        }
    }
}
