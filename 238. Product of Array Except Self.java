///////////////////////////////////////////////////////////////
//  Solution 1.      Left and Right product lists
//  Time Complexity  O(N)
//  Space Complexity O(N)
///////////////////////////////////////////////////////////////

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        // The length of the input array 
        int length = nums.length;
        
        int[] l = new int[length];
        int[] r = new int[length];

        // Final answer array to be returned
        int[] result = new int[length];
        result[0] = 1;
        
        l[0] = 1;
        for(int i=1; i<length; i++){
            // l[i-1] already contains the product of elements to the left of 'i-1'
            l[i] = nums[i-1] * l[i-1];
        }
        
        r[length -1] = 1;
        for(int i=length-2; i>=0; i--){
            // r[i+1] already contains the product of elements to the right of 'i+1'
            r[i] = nums[i+1] * r[i+1];
        }
        
        // Build the result array
        for(int i=0; i<length; i++){
            result[i] = l[i] * r[i];
        }
        
        return result;
        
    }
}


///////////////////////////////////////////////////////////////
//  Solution 2.      O(1) space approach
//  Time Complexity  O(N)
//  Space Complexity O(1)
///////////////////////////////////////////////////////////////

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];

        result[0] = 1;

        for(int i=1; i<length; i++){
            // result[i-1] already contains the product of elements the left of 'i-1'
            result[i] = nums[i-1] * result[i-1];        // make product
        }

        int r = 1;
        for(int i=length-1; i>=0; i--){
            result[i] = result[i] * r;
            r *= nums[i];
        }
        return result;

    }
}