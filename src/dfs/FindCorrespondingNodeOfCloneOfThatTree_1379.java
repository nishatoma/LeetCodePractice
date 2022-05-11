package dfs;

import trees.TreeNode;

public class FindCorrespondingNodeOfCloneOfThatTree_1379 {

    public final TreeNode<Integer> getTargetCopy(final TreeNode<Integer> original, final TreeNode<Integer> cloned, final TreeNode<Integer> target) {
        if (original == null || original == target) {
            return cloned;
        }

        TreeNode<Integer> res = getTargetCopy(original.getLeft(), cloned.getLeft(), target);

        if (res != null) return res;

        return getTargetCopy(original.getRight(), cloned.getRight(), target);
    }
}
