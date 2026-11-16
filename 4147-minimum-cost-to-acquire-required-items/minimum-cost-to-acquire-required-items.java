class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(cost1 + cost2 <= costBoth) {
            return (long)need1*cost1 + (long)need2*cost2;
        }

        long min = Math.min(need1, need2);
        long totalMinCost = costBoth*min;
        need1 -= min;
        need2 -= min;
        if(need1 > 0) totalMinCost += (long)need1*Math.min(cost1, costBoth);
        if(need2 > 0) totalMinCost += (long)need2*Math.min(cost2, costBoth);

        return totalMinCost;
    }
}