class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int icecreams = 0;
        for(int cost : costs) {
            if(coins >= cost) {
                icecreams++;
                coins -= cost;
            }
            else return icecreams;
        }
        return costs.length;
    }
}