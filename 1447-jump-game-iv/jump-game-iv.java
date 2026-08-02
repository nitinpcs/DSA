class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k->new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int idx = q.poll();
                if(idx == n-1) return steps;
                if(idx-1 >= 0 && !vis[idx-1]) {
                    q.add(idx-1);
                    vis[idx-1] = true;
                }
                if(idx+1 < n && !vis[idx+1]) {
                    q.add(idx+1);
                    vis[idx+1] = true;
                }
                if(map.containsKey(arr[idx])) {
                    for(int i : map.get(arr[idx])) {
                        if(vis[i]) continue;
                        q.add(i);
                        vis[i] = true;
                    }
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }
        return -1;
    }
}