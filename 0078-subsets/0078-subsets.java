class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // No sort needed — all elements are unique, no dup-skip required
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // Snapshot current path — every node (not just leaf) is a valid subset
        result.add(List.copyOf(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);               // choose current element
            backtrack(nums, i + 1, path, result); // explore (i+1 ensures no reuse)
            path.remove(path.size() - 1);    // unchoose (backtrack)
        }
    }
}