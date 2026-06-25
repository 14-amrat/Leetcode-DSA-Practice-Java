class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] candidates, int remaining, int start, List<Integer> current) {
        // base cases
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0) return;  // prune

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);              // CHOOSE
            backtrack(candidates, remaining - candidates[i], i, current); // i not i+1
            current.remove(current.size() - 1);     // UNCHOOSE
        }
    }
}