
/** Naive Linear Search */
// class Solution {
//    public boolean containsDuplicate(int[] nums) {
//         for (int i = 0; i < nums.length; ++i) {
//             for (int j = 0; j < i; ++j) {
//                 if (nums[j] == nums[i]) return true;  
//             }
//         }
//         return false;
//     }
//     // Time Limit Exceeded
// }


// /** Sorting */
class Solution {
   public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}

/** Hash Table */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>(nums.length);
        
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }else{
                set.add(i);
            }
        }
        return false;
    }
}