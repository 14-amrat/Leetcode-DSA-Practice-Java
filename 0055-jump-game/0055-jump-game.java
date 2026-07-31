class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // Can't reach this index
            if (i > maxReach) return false;
            
            // Update furthest reachable
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Early exit
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
}