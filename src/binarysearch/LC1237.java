package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LC1237 {
//    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        // What if we try all the values between 1 and 1000 for X and Y?
//        // for X, we can move 1 by 1, for Y, we can do binary searc the parameter space
//        // Make answer list
//        int limit = 1000;
//        List<List<Integer>> res = new ArrayList<>();
//        // Search 1 to 1000 for X
//        // No need to search 1000 for Y if we found for example answer
//        // at 500..
//        int prev = limit;
//        for (int x = 1; x <= limit; ++x) {
//            // Do binary search on Y possible parameters..
//            int lo = 1, hi = prev;
//            while (lo <= hi) {
//                int mid = lo + (hi - lo) / 2;
//                // Try the function call now..
//                int result = customfunction.f(x, mid);
//                // Check the result
//                if (result == z) {
//                    // Get a new list
//                    List<Integer> list = new ArrayList<>();
//                    list.add(x);
//                    list.add(mid);
//                    res.add(list);
//                    prev = mid;
//                    break;
//                } else if (result > z) {
//                    // Then try a smaller y
//                    hi = mid - 1;
//                } else {
//                    // Try a biger Y
//                    lo = mid + 1;
//                }
//            }
//        }
//        return res;
//    }
}
