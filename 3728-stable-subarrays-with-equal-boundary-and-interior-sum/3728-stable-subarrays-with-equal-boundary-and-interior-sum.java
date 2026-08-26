class Solution {
    public long countStableSubarrays(int[] capacity) {
        long count = 0;
        int n = capacity.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity[i];
        }
        
        // Map<capacity_value, Map<prefix[l] + 2*capacity[l], count>>
        Map<Integer, Map<Long, Integer>> map = new HashMap<>();
        
        for (int r = 0; r < n; r++) {
            // Query: count matching l values in [0, r-2]
            if (r >= 2) {
                if (map.containsKey(capacity[r])) {
                    long target = prefix[r];
                    count += map.get(capacity[r]).getOrDefault(target, 0);
                }
            }
            
            // Add position r-1 to map (for future r's)
            if (r >= 1) {
                int capRm1 = capacity[r - 1];
                long keyRm1 = prefix[r - 1] + 2L * capacity[r - 1];
                
                map.putIfAbsent(capRm1, new HashMap<>());
                map.get(capRm1).merge(keyRm1, 1, Integer::sum);
            }
        }
        
        return count;
    }
}