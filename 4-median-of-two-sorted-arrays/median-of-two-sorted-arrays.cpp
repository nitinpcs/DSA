class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1) ;
        }

        int n = nums1.size();
        int m = nums2.size();
        int leftSize = (n+m+1)/2;
        int start = 0;
        int end = n;
        while(start <= end) {
            int partitionA = (start + end)/2;
            int partitionB = leftSize - partitionA;

            int leftA = (partitionA == 0) ? INT_MIN : nums1[partitionA - 1];
            int rightA = (partitionA == n) ? INT_MAX : nums1[partitionA];

            int leftB = (partitionB == 0) ? INT_MIN : nums2[partitionB - 1];
            int rightB = (partitionB == m) ? INT_MAX : nums2[partitionB];

            if(leftA <= rightB && leftB <= rightA) {
                if((n+m) % 2 == 1) {
                    return std::max(leftA, leftB);
                }
                else {
                    return (std::max(leftA, leftB) + std::min(rightA, rightB)) / 2.0;
                }
            }

            else if(leftA > rightB) {
                end = partitionA - 1;
            }

            else {
                start = partitionA + 1;
            }
        }

        return 0.0;
    }
};