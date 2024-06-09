class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
         int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // Initialize with 0:1 to handle sum exactly divisible by k
        
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            
            // Adjust remainder to be positive if it's negative
            if (remainder < 0) {
                remainder += k;
            }
            
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
                remainderCount.put(remainder, remainderCount.get(remainder) + 1);
            } else {
                remainderCount.put(remainder, 1);
            }
        }
        
        return count;
        
    }
}