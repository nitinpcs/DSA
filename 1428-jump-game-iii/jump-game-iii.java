class Solution {
    public boolean canReach(int[] nums, int start) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int i = q.poll();
            if(nums[i] == 0) return true;

            int temp1 = i + nums[i];
            int temp2 = i - nums[i];

            if (temp1 < n && !visited[temp1]) {
                q.add(temp1);
                visited[temp1] = true;
            }
            if (temp2 >= 0 && !visited[temp2]) {
                q.add(temp2);
                visited[temp2] = true;
            }

        }

        return false;
    }
}