class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] freq = new int[n][11];
        for(int[] row : pick) {
            int x = row[0];
            int y = row[1];
            freq[x][y]++;
        }
        int winners = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=10; j++) {
                if(freq[i][j] >= i+1) {
                    winners++;
                    break;
                }
            }
        }
        return winners;
    }
}