package heap;

import java.util.*;

public class SearchSuggestionsSystem_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // PQ solution
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // Final result list
        List<List<String>> res = new ArrayList<>();
        // Max size of Q
        int max = 3;
        // searchWord length
        int n = searchWord.length();

        // Iterate 'by typing' single character each time
        for (int i = 1; i <= n; ++i) {
            // Get temp string
            String temp = searchWord.substring(0, i);

            // Iterate over the products array
            for (String prod : products) {
                // If the product starts with the
                // current typed word, add it to the PQ
                if (prod.startsWith(temp)) {
                    pq.offer(prod);
                }

                // Remove excess words
                if (pq.size() > max) {
                    pq.poll();
                }
            }

            // Add the words from PQ to the temp list
            LinkedList<String> list = new LinkedList<>();

            // While the PQ is not empty
            while (!pq.isEmpty()) {
                list.addFirst(pq.poll());
            }

            // Add to final list
            res.add(new LinkedList<>(list));
        }

        // return final result
        return res;
    }
}
