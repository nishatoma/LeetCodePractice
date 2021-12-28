package intervals;

import java.util.Comparator;
import java.util.List;


public class MeetingRooms_252 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        // Sort the array;
        intervals.sort(Comparator.comparingInt(Interval::getStart));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getStart() < intervals.get(i - 1).getEnd()) {
                return false;
            }
        }
        return true;
    }
}


