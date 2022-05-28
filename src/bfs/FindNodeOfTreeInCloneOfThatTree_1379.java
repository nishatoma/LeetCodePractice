package bfs;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindNodeOfTreeInCloneOfThatTree_1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        q.offer(cloned);
        q2.offer(original);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode curr2 = q2.poll();


            if (curr2 == target) return curr;

            if (curr.getLeft() != null) q.offer(curr.getLeft());
            if (curr.getRight() != null) q.offer(curr.getRight());

            if (curr2.getLeft() != null) q2.offer(curr2.getLeft());
            if (curr2.getRight() != null) q2.offer(curr2.getRight());
        }

        return null;
    }
}
