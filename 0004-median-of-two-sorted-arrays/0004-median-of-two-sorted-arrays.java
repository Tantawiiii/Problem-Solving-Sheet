class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int medianPos = totalLength / 2;
        // Check is even or individual
        boolean isEven = totalLength % 2 == 0;
        
        int i = 0, j = 0, count = 0, current = 0, previous = 0;
        
        
        // marge 2 arrays 
        while (count <= medianPos) {
            previous = current;
            
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                current = nums1[i];
                i++;
            } else {
                current = nums2[j];
                j++;
            }
            
            count++;
        }
        
        if (isEven) {
            return (previous + current) / 2.0;
        } else {
            return current;
        }
    }
}