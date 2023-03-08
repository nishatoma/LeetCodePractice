package trees;

import java.util.ArrayList;
import java.util.List;

public class LC1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Our result list
        List<Integer> res = new ArrayList<>();
        // If both are null
        if (root1 == null && root2 == null) {
            return res;
        }
        // Otherwise if only root1 is null
        if (root1 == null ){
            return getList(root2, new ArrayList<>());
        }
        // If root2 is null
        if (root2 == null) {
            return getList(root1, new ArrayList<>());
        }
        // Otherwise continue here
        List<Integer> a = getList(root1, new ArrayList<>());
        List<Integer> b = getList(root2, new ArrayList<>());

        // make indices for tracking a and b
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            // Get both elements from list
            int num1 = a.get(i);
            int num2 = b.get(j);
            // Compare
            if (num1 < num2) {
                // Add num1 to result first
                res.add(num1);
                // Increment i
                ++i;
            } else {
                res.add(num2);
                // increment j
                ++j;
            }
        }
        // We could have a case where i is not finished yet
        while (i < a.size()) {
            res.add(a.get(i++));
        }
        // Same with j
        while (j < b.size()) {
            res.add(b.get(j++));
        }
        // Return main res in the end
        return res;
    }

    // Helper method to convert binary search tree toa list
    private List<Integer> getList(TreeNode root, List<Integer> curr) {
        if (root == null) {
            return curr;
        }
        List<Integer> left = getList(root.left, curr);
        curr.add((int) root.val);
        List<Integer> right = getList(root.right, curr);

        return curr;
    }
}
