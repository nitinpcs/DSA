class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0;
        int i = cost.length - 1;
        Arrays.sort(cost);
        while(i >= 0) {
            minCost += cost[i];
            if(i-1 >= 0) {
                minCost += cost[--i];
            }    
            i -= 2;
        } 
        return minCost;
    }
}