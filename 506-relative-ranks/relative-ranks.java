class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] idx = new Integer[n];
        for(int i=0; i<n; i++) idx[i] = i;

        Arrays.sort(idx, (a,b)-> score[b]- score[a]);

        int count = 1;
        String[] rank = new String[n];
        for(int i=0; i<n; i++) {
            if(count == 1){
                rank[idx[i]] = "Gold Medal";
            }
            else if(count == 2) {
                rank[idx[i]] = "Silver Medal";
            } 
            else if(count == 3) {
                rank[idx[i]] = "Bronze Medal";
            }
            else {
                rank[idx[i]] = count + "";
            }
            count++;
        }

        return rank;
    }
}