class Solution {
    public List<String> commonChars(String[] words) {
       
        // Start with the character count of the first word
        Map<Character, Integer> commonCount = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            commonCount.put(c, commonCount.getOrDefault(c, 0) + 1);
        }
        
        // Update the commonCount with the character count of the remaining words
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> currentCount = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                currentCount.put(c, currentCount.getOrDefault(c, 0) + 1);
            }
            
            for (char c : commonCount.keySet()) {
                if (currentCount.containsKey(c)) {
                    commonCount.put(c, Math.min(commonCount.get(c), currentCount.get(c)));
                } else {
                    commonCount.put(c, 0);
                }
            }
        }
        
        // Generate the list of common characters
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : commonCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }
        
        return result;
    }
}