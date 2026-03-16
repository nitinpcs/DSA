class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 0; i < n - 1; i++) {
            if(rating[i] < rating[i+1]) {
                candies[i+1] = candies[i] + 1;
            }
        }

        for(int i = n-2; i>=0; i--) {
            if(rating[i] > rating[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] +1);
            }
        }

        return Arrays.stream(candies).sum();
    }
}