package dsu;

import java.util.*;

public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Initialize the structure
        UF uf = new UF();
        // Result variable
        List<List<String>> res = new ArrayList<>();
        // For each account, add to emailToNode, union by email
        for (List<String> account : accounts) {
            if (account.size() <= 1) continue;
            // Otherwise, let's process the account
            // Get the account owner
            String owner = account.get(0);
            // Add owner and email with the ranks
            uf.addEmail(owner, account.get(1));
            // For the rest of the emails, also add them and union them
            for (int i = 2; i < account.size(); ++i) {
                uf.addEmail(owner, account.get(i));
                // Union
                uf.union(account.get(1), account.get(i));
            }
        }

        // Create the merged groups with the sorted email
        Map<String, Set<String>> map = new HashMap<>();
        // Loop through all the accounts
        for (List<String> account : accounts) {
            if (account.size() <= 1) continue;
            // Get the representative of any email in that account
            String parent = uf.find(account.get(1));
            // Create an entry in the map with an empty set
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeSet<>());
            }
            // Get current tree set
            Set<String> currGroup = map.get(parent);
            // Add the remaining emails
            for (int i = 1; i < account.size(); ++i) {
                currGroup.add(account.get(i));
            }
        }

        // Now loop over the map and add the accounts to the
        // result list
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            // Create result sub list
            List<String> account = new ArrayList<>();
            // Create the account owner
            String owner = uf.getOwner(entry.getKey());
            // Get all the emails of the owner
            Set<String> emails = entry.getValue();
            // Add to account
            account.add(owner);
            account.addAll(emails);
            // Add to final res
            res.add(account);
        }
        return res;
    }

    private class UF {
        Map<String, Node> emailToNode;

        public UF() {
            emailToNode = new HashMap<>();
        }

        // Adds a new email, associated with account
        // with an initialized rank of zero.
        public void addEmail(String owner, String email) {
            if (!emailToNode.containsKey(email)) {
                emailToNode.put(email, new Node(owner, email, 0));
            }
        }

        public String find(String email) {
            Node node = emailToNode.get(email);

            if (node.parent == email) {
                return email;
            }
            return node.parent = find(node.parent);
        }

        // Union of two emails
        public void union(String emailX, String emailY) {
            String parentX = find(emailX);
            String parentY = find(emailY);

            // No need, same set
            if (parentX.equals(parentY)) return;
            // Get the nodes
            Node node1 = emailToNode.get(parentX);
            Node node2 = emailToNode.get(parentY);

            if (node1.rank >= node2.rank) {
                node2.parent = parentX;
                // if same rank
                if (node2.rank == node1.rank) {
                    node1.rank++;
                }
            } else {
                node1.parent = parentY;
            }
        }

        // Get current owner from email
        public String getOwner(String email) {
            return emailToNode.get(email).account;
        }
    }

    private class Node {
        String parent;
        String account;
        int rank;

        public Node(String account, String parent, int rank) {
            this.account = account;
            this.parent = parent;
            this.rank = rank;
        }
    }

}
