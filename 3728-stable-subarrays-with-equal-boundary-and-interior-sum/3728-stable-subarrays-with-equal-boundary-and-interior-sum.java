
class Solution {
    public long countStableSubarrays(int[] capacity) {

        int n = capacity.length;

        if (n < 3) {
            return 0;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity[i];
        }

        HashMap<Integer, HashMap<Long, Integer>> map = new HashMap<>();

        long answer = 0;

        for (int r = 2; r < n; r++) {

            int l = r - 2;

            long key = prefix[l] + 2L * capacity[l];

            map
                .computeIfAbsent(capacity[l], k -> new HashMap<>())
                .merge(key, 1, Integer::sum);

            int value = capacity[r];

            if (map.containsKey(value)) {
                answer += map.get(value).getOrDefault(prefix[r], 0);
            }
        }

        return answer;
    }
}