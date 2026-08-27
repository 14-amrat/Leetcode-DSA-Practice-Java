class NodeValue {
    public int minNode, maxNode, sum, maxSum;

    NodeValue(int minNode, int maxNode, int sum, int maxSum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
        this.maxSum = maxSum;
    }
}

class Solution {
    private NodeValue helper(TreeNode root) {
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // Current node is greater than max in left and smaller than min in right, it is a valid BST
        if(left.maxNode < root.val && right.minNode > root.val) {
            // It is BST
            int sum = left.sum + root.val + right.sum;

            return new NodeValue(Math.min(root.val, Math.min(left.minNode, right.minNode)), Math.max(root.val, Math.max(left.maxNode, right.maxNode)), sum, Math.max(0, Math.max(sum, Math.max(left.maxSum, right.maxSum))));
        }

        // Otherwise, return [-inf, inf] so that parent can't be a valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, Math.max(left.maxSum, right.maxSum));
    }

    public int maxSumBST(TreeNode root) {
        return helper(root).maxSum;
    }
} 