class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                ans = Math.min(ans, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }
        return ans == n+1 ? -1 : ans;
    }

    int reverse(int n) {
        int rev = 0;
        while(n > 0) {
            rev = rev*10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}