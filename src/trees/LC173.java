package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC173 {
    List<TreeNode> list;
    int pointer;

    public LC173(TreeNode root) {
        this.list = new ArrayList<>();
        this.pointer = 0;
        getInorderList(root, this.list);
    }

    public int next() {
        return (int) this.list.get(this.pointer++).val;
    }

    public boolean hasNext() {
        return this.pointer < this.list.size();
    }

    private void getInorderList(TreeNode root, List<TreeNode> myList) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Node
            TreeNode node = stack.pop();
            myList.add(node);
            curr = node.right;
        }
    }
}