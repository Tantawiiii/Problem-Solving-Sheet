class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer, Integer> coMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (coMap.containsKey(complement)) {
                return new int[]{
                    coMap.get(complement), i
                    };
            }

            coMap.put(nums[i], i);
        }

        return new int[]{};
    }
}