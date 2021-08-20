///////////////////////////////////////////////////////////////
//  Solution 1.      List Operation
//  Time Complexity  O(N^3)
//  Space Complexity O(N)
///////////////////////////////////////////////////////////////
class Solution {
  public int singleNumber(int[] nums) {
    List<Integer> no_duplicate_list = new ArrayList<>();

    for (int i : nums) {
      if (!no_duplicate_list.contains(i)) {
        no_duplicate_list.add(i);
      } else {
        no_duplicate_list.remove(new Integer(i));
      }
    }
    return no_duplicate_list.get(0);
  }
}


///////////////////////////////////////////////////////////////
//  Solution 2.      Hash Table
//  Time Complexity  O(N)
//  Space Complexity O(N)
///////////////////////////////////////////////////////////////
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hash_table = new HashMap<>();

    for (int i : nums) {
      hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (hash_table.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
}



///////////////////////////////////////////////////////////////
//  Solution 3.      Math
//  Time Complexity  O(N)
//  Space Complexity O(N)
///////////////////////////////////////////////////////////////
class Solution {
  public int singleNumber(int[] nums) {
    int sumOfSet = 0, sumOfNums = 0;
    Set<Integer> set = new HashSet();
      
    //   2a + 2b + 2c    2 * ( a + b + c)
    // -(2a + 2b + c)    (2a + 2b + c)
    // --------------
    //             c

    for (int num : nums) {
      if (!set.contains(num)) {
        set.add(num);
        sumOfSet += num;
      }
      sumOfNums += num;
    }
    return 2 * sumOfSet - sumOfNums;
  }
}

///////////////////////////////////////////////////////////////
//  Solution 4.      Bit Manipulation
//  Time Complexity  O(N)
//  Space Complexity O(1)
///////////////////////////////////////////////////////////////
class Solution {
    public int singleNumber(int[] nums) {
        
        //  xor operation => a ^ 0 = a
        //                  a ^ a = 0
        // a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b  <----- catch the different number
        
        int result = 0;
        
        for(int i : nums){
            result ^= i;
        }
        
        return result;
    }
}