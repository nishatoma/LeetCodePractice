package trees;

import java.util.*;

public class TreeNode<E> {

    private E val;
    private TreeNode<E> left;
    private TreeNode<E> right;

    private TreeNode() {
    }

    public TreeNode(E val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(E val, TreeNode<E> left, TreeNode<E> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public static <E> List<TreeNode<E>> depthFirstValues(TreeNode<E> root) {
        Stack<TreeNode<E>> stack = new Stack<>();
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> curr = stack.pop();
            result.add(curr);

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }

        return result;

    }

    public static <E> List<TreeNode<E>> depthFirstValuesRecursive(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        } else {
            result.add(root);
        }

        result.addAll(depthFirstValuesRecursive(root.left));
        result.addAll(depthFirstValuesRecursive(root.right));

        return result;
    }

    public static <E> List<TreeNode<E>> breadthFirstValues(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Initialize queue and enqueue the root first
        Queue<TreeNode<E>> queue = new ArrayDeque<>();
        queue.add(root);

        // As long as the queue is not empty
        // dequeue the first element and put it into a variable
        while (!queue.isEmpty()) {
            TreeNode<E> curr = queue.poll();
            // The result will always be added in order
            result.add(curr);

            // if the left is not empty, enqueue it
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            // if the right is not empty, enqueue it
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return result;
    }

    public static <E> boolean findNode(TreeNode<E> root, E val) {
        if (root == null) {
            return false;
        }

        // Iterate with BFS
        Queue<TreeNode<E>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<E> curr = queue.poll();
            if (curr.getVal() == val) {
                return true;
            }
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return false;
    }

    public static <E> boolean findNodeDfsRecursive(TreeNode<E> root, E val) {
        if (root == null) {
            return false;
        }
        if (root.getVal() == val) {
            return true;
        }
        return findNodeDfsRecursive(root.getLeft(), val) || findNodeDfsRecursive(root.getRight(), val);
    }

    public static int getTreeSumDFS(TreeNode<Integer> root) {
        int treeSum = 0;
        if (root == null) {
            return treeSum;
        }

        // Stack approach
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        // Iterate over the whole tree now depth first
        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            // Add the value of the node to the treeSum
            treeSum += curr.getVal();
            // Iterate over the children now
            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }
        return treeSum;
    }

    public static int getTreeSumDfsRecursive(TreeNode<Integer> root) {
        int treeSum = 0;
        if (root == null) {
            return 0;
        } else {
            treeSum += root.getVal();
        }

        return treeSum + getTreeSumDfsRecursive(root.getLeft()) + getTreeSumDfsRecursive(root.getRight());
    }

    public static int getTreeSumBfs(TreeNode<Integer> root) {
        int treeSum = 0;
        // If the parent node is null, just return 0.
        if (root == null) {
            return treeSum;
        }
        // Make a Queue for our BFS approach and iterate over all the leaves
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        // push the parent first
        queue.add(root);
        // while the queue is not empty, iterate over and add the value of
        // all the elements to the treeSum.
        while (!queue.isEmpty()) {
            // Remove the element at the head of queue
            TreeNode<Integer> curr = queue.poll();
            // And then add it to the sum:
            treeSum += curr.getVal();
            // Now add the left and right children to the queue, respectively.
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            // Same with the right child
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return treeSum;
    }

    public static int treeMinDFS(TreeNode<Integer> root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }

        // Iterate over the elements using depth first
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        // While the stack is not empty, iterate of the elements:
        while (!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            // If we find a smaller value each iteration,
            // update the min value.
            min = Math.min(curr.getVal(), min);
            // Now iterate over the children
            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            // Same for left
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }
        return min;
    }

    public static int treeMinDfsRecursive(TreeNode<Integer> root) {

        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        } else {
            min = root.getVal();
        }

        int minLeft = Math.min(min, treeMinDfsRecursive(root.getLeft()));
        int minRight = Math.min(min, treeMinDfsRecursive(root.getRight()));

        return Math.min(minLeft, minRight);
    }

    public static int treeMinBFS(TreeNode<Integer> root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }
        // Queue for BFS
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();

            min = Math.min(min, curr.getVal());

            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }

            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return min;
    }

    public static int getMaxRootToLeafPathSum(TreeNode<Integer> root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return max;
        }
        if (root.getRight() == null && root.getLeft() == null) {
            return root.getVal();
        }

        int leftChildMax = Math.max(getMaxRootToLeafPathSum(root.getLeft()), max);
        int rightChildMax = Math.max(getMaxRootToLeafPathSum(root.getRight()), max);

        return root.getVal() + Math.max(leftChildMax, rightChildMax);
    }

    public static <E> List<TreeNode<E>> preOrder(TreeNode<E> root) {
        List<TreeNode<E>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> curr = stack.pop();

            list.add(curr);

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }

        return list;
    }

    public static <E> List<TreeNode<E>> preOrderRecursive(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        result.add(root);
        result.addAll(preOrderRecursive(root.getLeft()));
        result.addAll(preOrderRecursive(root.getRight()));

        return result;
    }

    public static <E> List<TreeNode<E>> inOrderRecursive(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result = inOrderRecursive(root.getLeft());
        System.out.println("Added: " + root.getVal());
        result.add(root);
        result.addAll(inOrderRecursive(root.getRight()));

        return result;
    }

    public static <E> List<TreeNode<E>> postOrderRecursive(TreeNode<E> root) {
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        result.addAll(postOrderRecursive(root.getLeft()));
        result.addAll(postOrderRecursive(root.getRight()));
        System.out.println("Added: " + root.getVal());
        result.add(root);

        return result;
    }

    public static <E> List<TreeNode<E>> inOrderIterative(TreeNode<E> root){
        List<TreeNode<E>> result = new ArrayList<>();

        Stack<TreeNode<E>> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            result.add(root);
            root = root.getRight();
        }

        return result;
    }

    public static <E> List<TreeNode<E>> postOrderIterative(TreeNode<E> root){
        List<TreeNode<E>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode<E>> stack1 = new Stack<>();
        Stack<TreeNode<E>> stack2 = new Stack<>();

        // push root element
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<E> curr = stack1.pop();
            stack2.push(curr);

            if (curr.getLeft() != null) {
                stack1.push(curr.getLeft());
            }

            if (curr.getRight() != null) {
                stack1.push(curr.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop());
        }

        return result;
    }
}
