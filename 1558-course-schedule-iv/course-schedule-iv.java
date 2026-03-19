class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] isReachable = new boolean[numCourses][numCourses];
        for(int[] p : prerequisites) {
            int u = p[0];
            int v = p[1];
            isReachable[u][v] = true;
        }

        for(int k=0; k<numCourses; k++){
            for(int i=0; i<numCourses; i++){
                for(int j=0; j<numCourses; j++){
                    if(isReachable[i][k] && isReachable[k][j]){
                        isReachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries) {
            int u = q[0];
            int v = q[1];
            boolean val = isReachable[u][v];
            ans.add(val);
        }
        return ans;
    }
}