class Solution {
public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    
    Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
    q.offer(new Pair<>(root, 0L));
    
    long maxWidth = 0;
    
    while (!q.isEmpty()) {
        int size = q.size();
        long minPos = Long.MAX_VALUE, maxPos = Long.MIN_VALUE;
        
        for (int i = 0; i < size; i++) {
            TreeNode node = q.peek().getKey();
            long pos = q.poll().getValue();
            
            minPos = Math.min(minPos, pos);
            maxPos = Math.max(maxPos, pos);
            
            if (node.left != null) q.offer(new Pair<>(node.left, 2 * pos + 1));
            if (node.right != null) q.offer(new Pair<>(node.right, 2 * pos + 2));
        }
        
        maxWidth = Math.max(maxWidth, maxPos - minPos + 1);
    }
    
   return (int) maxWidth; 
}
 }