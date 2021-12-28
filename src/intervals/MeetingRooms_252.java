package intervals;

import java.util.Comparator;
import java.util.List;


public class MeetingRooms_252 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        // Sort the array;
        intervals.sort(Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
