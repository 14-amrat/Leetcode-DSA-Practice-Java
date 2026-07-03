// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int left = 0, right = nums.length-1;
//         while(left < right){
//             int mid = (left + right)/2;
//             if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
//                 left = mid + 1;
//             else
//                 right = mid;
//         }
//         return nums[left];
//     }   
// }
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;   // Skip the pair
        }

        return nums[nums.length - 1];
    }
}