class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDeg[prerequisites[i][0]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(inDeg[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int t = q.poll();
            count++;
            for(int ele : adj.get(t)){
                inDeg[ele]--;
                if(inDeg[ele] == 0) q.add(ele);
            }
        }
        return count == numCourses;
    }
}