package trees;

class DeepestLeavesSum1302 {
    static int sum = 0;
    static int maxDepth = 0;


    public static void main(String[] args) {
        // Tree Node
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum(root));

    }

    private static int deepestLeavesSum(TreeNode root) {
        findSum(root, 1);
        return sum;
    }

    public static void findSum(TreeNode node, int level) {
        if (node != null) {
            if (level > maxDepth) {
                sum = 0;
                maxDepth = level;
            }
            if (level == maxDepth) {
                sum += node.val;
            }
            findSum(node.left, level + 1);
            findSum(node.right, level + 1);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
