class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandy = candies[0];
        for(int i = 1; i < n; i++) maxCandy = Math.max(maxCandy, candies[i]);

        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            res.add(candies[i] + extraCandies >= maxCandy);
        }
        return res;
    }
}