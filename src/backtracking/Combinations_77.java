package backtracking;

import java.util.ArrayList;
import java.util.List;

class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {

        // Recursive Solution
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        backtrack(result, combo, 1, k, n);

        // Iterative solution
//         List<List<Integer>> result = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             result.add(Arrays.asList(i));
//         }

//         for (int i = 2; i <= k; i++) {
//             List<List<Integer>> newCombs = new ArrayList<>();
//             for (int j = i; j <= n; j++) {
//                 for (List<Integer> combo: result) {
//                     if (combo.get(combo.size() - 1) < j) {
//                         List<Integer> l = new ArrayList<>(combo);
//                         l.add(j);
//                         newCombs.add(new ArrayList<>(l));
//                     }
//                 }
//             }
//             result = newCombs;
//         }

        return result;
    }


    static void backtrack(List<List<Integer>> result,
                          List<Integer> combo,
                          int start,
                          int k,
                          int n) {

        if (k == 0) {
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            combo.add(i);
            backtrack(result, combo, i + 1, k - 1, n);
            combo.remove(combo.size() - 1);
        }
    }
}