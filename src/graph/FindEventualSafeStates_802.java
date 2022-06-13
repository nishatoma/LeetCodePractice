package graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {

    enum State {
        SAFE,
        UNSAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        // Number of nodes
        int n = graph.length;
        // Make an array for states
        State[] states = new State[n];
        // For each node
        for (int i = 0; i < n; ++i) {
            if (isSafe(graph, states, i)) res.add(i);
        }
        return res;
    }

    private boolean isSafe(int[][] graph, State[] states, int node) {
        // If we already have a node stored, no need to compute
        if (states[node] != null) return states[node] == State.SAFE;
        // Mark un-safe
        states[node] = State.UNSAFE;
        // visit neighbours
        for (int v : graph[node]) {
            if (!isSafe(graph, states, v)) return false;
        }
        // Mark safe if we did not return false
        states[node] = State.SAFE;
        // Return true if it is safe
        return true;
    }
}
