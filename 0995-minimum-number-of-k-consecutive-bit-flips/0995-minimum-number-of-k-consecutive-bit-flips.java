class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        
        Queue<Integer> flipQueue = new LinkedList<>();
        int flipCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
      
            if (!flipQueue.isEmpty() && flipQueue.peek() <= i - k) {
                flipQueue.poll();
            }
            
  
            if (flipQueue.size() % 2 == nums[i]) {
                if (i + k > nums.length) {
                    return -1;
                }
                flipQueue.offer(i);
                flipCount++;
            }
        }
        
        return flipCount;
        
    }
}