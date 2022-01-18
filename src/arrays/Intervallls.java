package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Intervallls {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
        // Write your code here
        // First sort the intervals so it's easier to work with that way
        intervals.sort(Comparator.comparingInt(list -> list.get(0)));

        // get the first interval in the list of intervals
        int first = intervals.get(0).get(0);
        int last = intervals.get(0).get(1);

        List<List<Integer>> res = new ArrayList<>();

        int j = 1;
        while (j < intervals.size()) {
            int s = intervals.get(j).get(0);
            int e = intervals.get(j).get(1);

            // since the list is sorted, we know the first interval start
            // is less than second intervals
            if (s <= last) {
                last = Math.max(last, e);
            } else {
                // otherwise we could not merge here,
                // so might as well just insert it into list.
                List<Integer> temp = new ArrayList<>();
                temp.add(first);
                temp.add(last);
                res.add(new ArrayList<>(temp));
                first = s;
                last = e;
            }
            j++;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(first);
        temp.add(last);
        res.add(new ArrayList<>(temp));

        List<List<Integer>> finalResult = new ArrayList<>();

        for (int i = 0; i < res.size(); i++){
            List<Integer> temp2 = new ArrayList<>();
            for (int k = 0; k < 2; k++){
                temp2.add(res.get(i).get(k));
            }
            finalResult.add(new ArrayList<>(temp2));
        }

        return finalResult;
    }
}
