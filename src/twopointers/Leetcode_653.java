package twopointers;

public class Leetcode_653 {

//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        return dfs(root, set, k);
//    }
//
//    // Recursive Solution
//    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
//        if (root == null) return false;
//        if (set.contains(k - root.val)) return true;
//        set.add(root.val);
//        return dfs(root.left, set, k) || dfs(root.right, set, k);
//    }

    // public boolean findTarget(TreeNode root, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     // Use inorder traversal
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode curr = root;
    //     while (!stack.isEmpty() || curr != null) {
    //         // Push all the way to left
    //         while (curr != null) {
    //             stack.push(curr);
    //             curr = curr.left;
    //         }

    //         // Get out of loop, process outermost element
    //         TreeNode node = stack.pop();
    //         // Process the node
    //         list.add(node.val);
    //         if (node.right != null) {
    //             // Make curr = right
    //             curr = node.right;
    //         }
    //     }
    //     // After this processing, we have a sorted list
    //     int left = 0, right = list.size() - 1;
    //     while (left < right) {
    //         int sum = list.get(left) + list.get(right);
    //         if (sum == k) return true;
    //         if (sum < k) {
    //             ++left;
    //         } else {
    //             --right;
    //         }
    //     }
    //     return false;
    // }

}
