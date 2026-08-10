class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] rowadj = new ArrayList[k+1];
        List<Integer>[] coladj = new ArrayList[k+1];

        for(int i=0; i<=k; i++) {
            rowadj[i] = new ArrayList<>();
            coladj[i] = new ArrayList<>();
        }
        for(int[] r : rowConditions) rowadj[r[1]].add(r[0]);
        for(int[] c : colConditions) coladj[c[1]].add(c[0]);

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        int[] state = new int[k+1];

        for(int i=1; i<=k; i++) {
            if(state[i] == 0) {
                if(!sort(rowadj, state, i, row)) return new int[0][0];
            }
        }
        state = new int[k+1];
        for(int i=1; i<=k; i++) {
            if(state[i] == 0) {
                if(!sort(coladj, state, i, col)) return new int[0][0];
            }
        }

        int[] rowpos = new int[k+1];
        int[] colpos = new int[k+1];

        for(int i=0; i<k; i++) {
            rowpos[row.get(i)] = i;
            colpos[col.get(i)] = i;
        }

        int[][] res = new int[k][k];
        for(int i=1; i<=k; i++) {
            res[rowpos[i]][colpos[i]] = i;
        }
        
        return res;
    }

    boolean sort(List<Integer>[] adj, int[] state, int i, List<Integer> l) {
        if(state[i] == 1) return false;
        if(state[i] == 2) return true;
        state[i] = 1;
        for(int nei : adj[i]) {
            if(!sort(adj, state, nei, l)) return false;
        }
        l.add(i);
        state[i] = 2;
        return true;
    }
}