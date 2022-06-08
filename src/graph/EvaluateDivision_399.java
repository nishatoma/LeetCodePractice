package graph;

import java.util.*;

public class EvaluateDivision_399 {

    class Node {
        String key;
        double value;
        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Construct our graph
        Map<String, List<Node>> graph = buildGraph(equations, values);

        // Initialize result array
        double[] res = new double[queries.size()];

        // For eac query
        for (int i = 0; i < queries.size(); ++i) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            res[i] = dfs(src, dst, new HashSet<>(), graph);
        }

        return res;
    }

    private double dfs(String src, String dst, Set<String> visited, Map<String, List<Node>> graph) {
        if ((!graph.containsKey(src) || !graph.containsKey(dst)) || !visited.add(src)) return -1.0;
        if (src.equals(dst)) return 1.0;

        for (Node node : graph.get(src)) {
            double res = dfs(node.key, dst, visited, graph);
            if (res != -1.0) return res * node.value;
        }
        return -1.0;
    }

    // Build our graph using equations and their values as nodes
    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();
        // Iterate over equations
        for (int i = 0; i < values.length; ++i) {
            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            graph.computeIfAbsent(src, k -> new ArrayList<>());
            graph.computeIfAbsent(dst, k -> new ArrayList<>());
            graph.get(src).add(new Node(dst, values[i]));
            graph.get(dst).add(new Node(src, 1.0 / values[i]));
        }
        return graph;
    }
}
