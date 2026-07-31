class Solution {
    public int countSequences(int[] nums, long k) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(nums, map, 1, 1, 0, k);
    }

    int dfs(int[] nums, Map<String, Integer> map, long num, long den, int idx, long k) {
        if(idx == nums.length) {
            return num == k*den ? 1 : 0;
        }
        String s = num+" "+den+" "+idx;
        if(map.containsKey(s)) return map.get(s);
        long g = gcd(num, den);
        num /= g;
        den /= g;

        int count = 0;
        count = dfs(nums, map, num*nums[idx], den, idx+1, k);
        count += dfs(nums, map, num, den*nums[idx], idx+1, k);
        count += dfs(nums, map, num, den, idx+1, k);

        map.put(s, count);
        return count;
    }

    long gcd(long x, long y) {
        return y==0 ? x : gcd(y, x%y);
    }
}