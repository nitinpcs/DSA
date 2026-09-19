class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lmax = 0, rmax = 0, sum = 0, l = 0, r = n-1;

        while(l <= r) {
            if(arr[l] < arr[r]) {
                lmax = Math.max(lmax, arr[l]);
                sum += lmax - arr[l];
                l++;
            }
            else {
                rmax = Math.max(rmax, arr[r]);
                sum += rmax - arr[r];
                r--;
            }
        }
        return sum;
    }
}