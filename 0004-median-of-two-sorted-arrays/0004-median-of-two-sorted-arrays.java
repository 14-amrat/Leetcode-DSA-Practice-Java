class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ✅ Step 1 — get lengths
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        // ✅ Step 2 — merge both sorted arrays into one
        int[] merged = new int[total];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }
        while (i < m) merged[k++] = nums1[i++];
        while (j < n) merged[k++] = nums2[j++];

        // ✅ Step 3 — find median using total length
        if (total % 2 == 1) {
            // odd → middle element
            return merged[total / 2];
        } else {
            // even → average of two middle elements
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }
}