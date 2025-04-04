class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        
        while (i < m) merged[k++] = nums1[i++]; // Add remaining elements
        while (j < n) merged[k++] = nums2[j++]; // Add remaining elements
        
        int total = m + n;
        if (total % 2 == 1) return merged[total / 2]; // Odd length
        return (merged[total / 2 - 1] + merged[total / 2]) / 2.0; // Even length
    }
}