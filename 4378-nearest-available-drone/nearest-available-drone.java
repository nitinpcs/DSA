class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDist = Integer.MAX_VALUE;
        int idx = -1;
        int i = 0;
        for(int[] d : drones) {
            int currDist = Math.abs(d[0]-target[0]) + Math.abs(d[1]-target[1]);
            if(currDist <= d[2]) {
                if(currDist < minDist) {
                    minDist = currDist;
                    idx = i;
                }
            }
            i++;
        }
        return idx;
    }
}