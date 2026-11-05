class Solution {
    public int maxSubArray(int[] nums) {
        
        // Start with first element
        int currentSum = nums[0];
        int maxSum     = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start fresh OR extend previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}


