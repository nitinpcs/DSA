class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Arrays.stream(costs).max().getAsInt();
        int[] count = new int[max + 1];
        for(int cost : costs) count[cost]++;
        int icecream = 0;
        for(int i = 1; i <= max; i++) {
            while(i <= coins && count[i] > 0) {
                icecream++;
                coins -= i;
                count[i]--;
            }
        }
        return icecream;
    }
}