package bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LexographicallySmallestStringAfterApplyingOperations_1625 {

    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;

        // Store the first string
        // in a queue for BFS
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);

        // Mark visited strings
        // to avoid duplicate visits
        Set<String> set = new HashSet<>();
        set.add(s);

        // Iterate over the queue
        while (!q.isEmpty()) {
            // Get the latest string
            String str = q.poll();

            // if it's lexographically smaller than what we have,
            // then update our smallest variable
            if (str.compareTo(smallest) < 0) smallest = str;

            // Apply both operations
            String op1 = add(str, a);
            String op2 = rotate(str, b);

            // If not visited, apply the result of
            // the summation to the queue
            if (!set.contains(op1)) {
                set.add(op1);
                q.offer(op1);
            }
            // Same with the rotation
            if (!set.contains(op2)) {
                set.add(op2);
                q.offer(op2);
            }
        }
        return smallest;
    }

    // Rotate a string b times to the right;
    private String rotate(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }

    // Add b to every number
    // in the string in odd indices, cycle back
    // to 0 if sum >= 10
    private String add(String s, int a) {
        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
        }

        return String.valueOf(arr);
    }
}
