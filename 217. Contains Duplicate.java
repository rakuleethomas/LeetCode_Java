///////////////////////////////////////////////////////////////
//  Solution 1.      Naive Linear Search 
//  Time Complexity  O(n^2)
//  Space Complexity O(1)
///////////////////////////////////////////////////////////////
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

///////////////////////////////////////////////////////////////
//  Solution 2.      Sorting                 
//  Time Complexity  O(nlogn)
//  Space Complexity O(1)            
///////////////////////////////////////////////////////////////
class Solution {
   public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);       // heap sort
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}

///////////////////////////////////////////////////////////////
//  Solution 3.      Hash Table
//  Time Complexity  O(n)
//  Space Complexity O(n)
///////////////////////////////////////////////////////////////
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashSet<Integer> set = new HashSet<Integer>(nums.length);
        
//         for(int i : nums){
//             if(set.contains(i)){
//                 return true;
//             }else{
//                 set.add(i);
//             }
//         }
//         return false;
//     }
// }
