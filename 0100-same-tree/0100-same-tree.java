class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            // both null
            if (node1 == null && node2 == null)
                continue;

            // one null
            if (node1 == null || node2 == null)
                return false;

            // values differ
            if (node1.val != node2.val)
                return false;

            // add children in same order
            queue1.add(node1.left);
            queue1.add(node1.right);

            queue2.add(node2.left);
            queue2.add(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}