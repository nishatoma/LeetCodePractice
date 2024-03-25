package string;

import java.util.*;

public class LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        // Map each email to an unique ID
        Map<String, Integer> emailToId = new HashMap<>();
        // initialize DSU
        DisjointSet dsu = new DisjointSet(n);

        // Loop through accounts
        for (int i = 0; i < n; ++i) {
            // Loop through emails
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                String email = accounts.get(i).get(j);
                // Get current email ID
                int currentNameId = i;
                // for each email, check if it exists
                if (emailToId.containsKey(email)) {
                    int oldNameId = emailToId.get(email);
                    dsu.union(oldNameId, currentNameId);
                } else {
                    emailToId.put(email, currentNameId);
                }
            }
        }
        // Now we can make a mapping from a specific ID -> Email
        Map<Integer, TreeSet> idToEmail = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = dsu.find(i);
            // Get a list of emails
            List<String> emails = accounts.get(i);
            idToEmail.putIfAbsent(root, new TreeSet<>());
            idToEmail.get(root).addAll(emails.subList(1, emails.size()));
        }

        // Make a result variable
        List<List<String>> res = new LinkedList<>();

        for (int id : idToEmail.keySet()) {
            String name = accounts.get(id).get(0);
            List<String> emails = new LinkedList<>(idToEmail.get(id));
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    public class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            rank = new int[n];
        }


        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }
}
