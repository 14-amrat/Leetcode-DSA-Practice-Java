// import java.util.*;

// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
        
//         Deque<Integer> maxDeque = new ArrayDeque<>();
//         Deque<Integer> minDeque = new ArrayDeque<>();

//         int left = 0;
//         int maxLength = 0;

//         for (int right = 0; right < nums.length; right++) {

//             // Maintain decreasing deque for maximum
//             while (!maxDeque.isEmpty() &&
//                    nums[maxDeque.peekLast()] < nums[right]) {
//                 maxDeque.pollLast();
//             }
//             maxDeque.offerLast(right);

//             // Maintain increasing deque for minimum
//             while (!minDeque.isEmpty() &&
//                    nums[minDeque.peekLast()] > nums[right]) {
//                 minDeque.pollLast();
//             }
//             minDeque.offerLast(right);

//             // Shrink window if invalid
//             while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {

//                 // Remove elements that are leaving the window
//                 if (maxDeque.peekFirst() == left) {
//                     maxDeque.pollFirst();
//                 }

//                 if (minDeque.peekFirst() == left) {
//                     minDeque.pollFirst();
//                 }

//                 left++;
//             }

//             maxLength = Math.max(maxLength, right - left + 1);
//         }

//         return maxLength;
//     }
// }

class Solution{
public int longestSubarray(int[] A, int limit) {
    int i = 0, j;
    TreeMap<Integer, Integer> m = new TreeMap<>();
    for (j = 0; j < A.length; j++) {
        m.put(A[j], 1 + m.getOrDefault(A[j], 0));
        if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
            m.put(A[i], m.get(A[i]) - 1);
            if (m.get(A[i]) == 0)
                m.remove(A[i]);
            i++;
        }
    }
    return j - i;
}
}