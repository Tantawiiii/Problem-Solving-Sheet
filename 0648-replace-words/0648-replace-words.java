class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Step 1: Convert the dictionary to a set for quick lookup
        Set<String> rootSet = new HashSet<>(dictionary);
        
        // Step 2: Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Step 3: Process each word in the sentence
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            String root = findRoot(word, rootSet);
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(root);
        }
        
        // Step 4: Convert the result to a string
        return result.toString();
    }
    
     private static String findRoot(String word, Set<String> rootSet) {
        // Iterate through each possible prefix length
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (rootSet.contains(prefix)) {
                return prefix;
            }
        }
        return word;
    }
}