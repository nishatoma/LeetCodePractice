package binarysearch;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {

    // Idea is to sort intervals as they are inserted basically..
    // So, we can use a treemap for this
    private Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        // Put the start time and increment, meaning we have
        // 1 event with this start time
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        // Similarly, if we see an endtime, it means we have a finished event
        // So the count is drecreased..
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
        // Now that we have inserted the time, loop through all the counters,
        // and see how many events are still going on.
        // Basically, the total values for start times - total values of end times
        // tells us # of ongoing events
        int ongoing = 0, k = 0;
        for (int value : map.values()) {
            k = Math.max(k, ongoing += value);
        }
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */