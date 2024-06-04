class Solution {
    public int appendCharacters(String s, String t) {
            int i = 0, j = 0;
        int lenS = s.length();
        int lenT = t.length();
        
        // Traverse through s and t
        while (i < lenS && j < lenT) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        
        // The remaining characters in t that were not matched
        return lenT - j;
    }
}