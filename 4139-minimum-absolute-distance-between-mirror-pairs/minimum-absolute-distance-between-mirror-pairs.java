class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans = (int)1e5;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans = Math.min(ans, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }
        return ans == 1e5 ? -1 : ans;
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