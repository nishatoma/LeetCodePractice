package topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class LoudAndRich_851 {
    // Basically, this problem wants us to find the
    // loudest person amongst the richest of people
    // for each person in the answer array..
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // build the graph
        List<Integer>[] graph = new ArrayList[n];
        // Build with empty array lists first
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        // Now construct the adj list/arr
        for (int[] group : richer) {
            // Second person has < money than first
            // So it's like a dependency!!
            // That means fpr each neighbour v of a certain node u,
            // we know for sure that v > u in terms of money!!
            graph[group[1]].add(group[0]);
        }
        // Construct a boolean array for visited nodes
        boolean[] seen = new boolean[n];
        // Answer array
        int[] ans = new int[n];
        // For each person, get now the quietest neighbour, with the biggest amount of
        // money!!
        for (int i = 0; i < n; ++i) {
            getQuietestPerson(graph, seen, i, quiet, ans);
        }
        return ans;
    }

    // get loudest person with biggest money
    int getQuietestPerson(List<Integer>[] graph, boolean[] seen, int src, int[] quiet, int[] ans) {
        if (seen[src]) return ans[src];
        seen[src] = true;
        // int quietness
        int min = quiet[src];
        int person = src;
        // for each neighbour
        for (int v : graph[src]) {
            int p = getQuietestPerson(graph, seen, v, quiet, ans);
            if (quiet[p] < min) {
                min = quiet[p];
                person = p;
            }
        }
        ans[src] = person;
        return person;
    }
}
