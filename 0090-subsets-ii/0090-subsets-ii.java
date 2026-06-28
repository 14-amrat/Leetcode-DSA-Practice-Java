class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort to bring duplicates adjacent — enables same-level dup detection
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // Every node in the recursion tree is a valid subset — add a snapshot
        result.add(List.copyOf(path));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicate at the SAME recursion level (not across levels)
            // e.g. [1,1,2]: when i=1 and start=0, nums[1]==nums[0] → skip
            // This prevents generating [1] twice from index 0 and index 1
            if (i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);           // choose
            backtrack(nums, i + 1, path, result); // explore (i+1 avoids reuse)
            path.remove(path.size() - 1); // unchoose (backtrack)
        }
    }
}