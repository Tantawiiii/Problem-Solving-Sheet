class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddFound = false;
        
        // Calculate the length of the longest palindrome
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                oddFound = true;
            }
        }
        
        if (oddFound) {
            length++;
        }
        
        return length;
    }
}