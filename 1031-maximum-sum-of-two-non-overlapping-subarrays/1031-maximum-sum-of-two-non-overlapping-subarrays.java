class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int n = nums.length;

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // firstLen before secondLen
        int ans1 = solve(prefix, firstLen, secondLen);

        // secondLen before firstLen
        int ans2 = solve(prefix, secondLen, firstLen);

        return Math.max(ans1, ans2);
    }

    private int solve(int[] prefix, int firstLen, int secondLen) {

        int maxFirst = 0;
        int answer = 0;

        // i = ending position of second subarray
        for (int i = firstLen + secondLen; i < prefix.length; i++) {

            // First subarray ends where second subarray begins
            int firstSum =
                    prefix[i - secondLen] -
                    prefix[i - secondLen - firstLen];

            maxFirst = Math.max(maxFirst, firstSum);

            // Current second subarray
            int secondSum =
                    prefix[i] -
                    prefix[i - secondLen];

            answer = Math.max(answer, maxFirst + secondSum);
        }

        return answer;
    }
}