class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: Get total sum of tree
        totalSum = treeSum(root);

        // Step 2: Find max product
        findMaxProduct(root);

        return (int) (maxProduct % MOD);
    }

    // DFS to calculate total sum
    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    // DFS to compute subtree sums and products
    private long findMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long left = findMaxProduct(node.left);
        long right = findMaxProduct(node.right);

        long subtreeSum = node.val + left + right;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
