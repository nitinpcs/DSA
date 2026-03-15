class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int total_sum = 0;

        for(int i = 0; i < n; i++) {
            int cur = 0;
            for(int j = i; j < n; j++) {
                cur += arr[j];
                if((j-i+1) % 2 != 0) total_sum += cur;
            }
        }
        return total_sum;
    }
}