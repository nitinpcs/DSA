class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] p = new Project[n];
        for(int i = 0; i < n; i++) {
            p[i] = new Project(capital[i], profits[i]);
        }
        Comparator<Project> byCapital = Comparator.comparingInt(s -> s.capital);
        Arrays.sort(p, byCapital);

        PriorityQueue<Integer> maximizeProfit = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int i = 0;
        while(k-- > 0) {
            while(i < n && p[i].capital <= w) {
                maximizeProfit.offer(p[i].profit);
                i++;
            }
            if(maximizeProfit.isEmpty()) return w;
            w += maximizeProfit.poll();
        }
        return w;
    }
}

class Project {
    int capital;
    int profit;
    Project(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}