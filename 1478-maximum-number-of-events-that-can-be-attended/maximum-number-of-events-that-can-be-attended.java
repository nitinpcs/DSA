class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int attended = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxDay = 0;
        for(int[] e : events) maxDay = Math.max(maxDay, e[1]);

        for(int i=1, j=0; i <= maxDay; i++) {
            while(j < n && events[j][0] <= i) {
                pq.add(events[j++][1]);
            }
            while(!pq.isEmpty() && pq.peek() < i) pq.poll();

            if(!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }

        return attended;
    }
}