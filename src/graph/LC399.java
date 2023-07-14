package graph;

import java.util.*;

public class LC399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Basic idead is to map the ratio values as a weighted edge between the variables
        // i.e A and B would be node,s and A -> B has value of 2, and B -> A has value of 0.5.

        // First we build a graph.
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        // Second, iterate over the queries
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                res[i] = -1.0;
                continue;
            }
            // Otherwise enter DFS, for each query that MIGHT have a key in the graph.
            res[i] = dfs(graph, new HashSet<>(), u, v);
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String u, String v) {
        // Check if they mapping exists
        if (graph.get(u).containsKey(v)) {
            return graph.get(u).get(v);
        }

        // Otherwise, explore other options
        visited.add(u);
        for (Map.Entry<String, Double> entry : graph.get(u).entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            double res = dfs(graph, visited, entry.getKey(), v);
            // Check if result is not - 1;
            if (res == -1.0) {
                continue;
            }
            return res * entry.getValue();
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); ++i) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            // Put the nodes in the map, and map them by ratio from
            // values array
            double ratio = values[i];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, ratio);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1.0 / ratio);
        }
        return graph;
    }
}
