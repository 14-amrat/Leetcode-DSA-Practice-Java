class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] nums,
                           int start,
                           List<Integer> subset,
                           List<List<Integer>> ans) {

        // Current subset is valid
        ans.add(new ArrayList<>(subset));

        // Try every remaining element
        for(int i = start; i < nums.length; i++) {

            // Choose
            subset.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, subset, ans);

            // Undo
            subset.remove(subset.size() - 1);
        }
    }
}