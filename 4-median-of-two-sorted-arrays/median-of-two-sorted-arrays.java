class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length;
        int m = nums2.length;
        int leftPart = (n + m + 1)/2;
        int start = 0;
        int end = n;
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;

        while(start <= end) {
            int partA = start + (end - start) / 2;
            int partB = leftPart - partA;

            int lA = partA == 0 ? MIN : nums1[partA - 1];
            int rA = partA == n ? MAX : nums1[partA];

            int lB = partB == 0 ? MIN : nums2[partB - 1];
            int rB = partB == m ? MAX : nums2[partB];

            if(lA <= rB && lB <= rA) {
                return (n + m) % 2 == 1 ? Math.max(lA, lB) : (Math.max(lA, lB) + Math.min(rA, rB)) / 2.0;
            }
            else if(lA > rB) {
                end = partA - 1;
            }
            else {
                start = partA + 1;
            }
        }
        return 0.0;
    }
}