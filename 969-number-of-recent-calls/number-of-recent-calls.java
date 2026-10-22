class RecentCounter {
    Queue<Integer> q ;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        int size = q.size();
        int count = 0;
        while(size-- > 0) {
            if(q.peek() >= t-3000 && q.peek() <= t) {
                q.add(q.poll());
                count++;
            } 
            else q.poll();
        }
        q.add(t);
        return count + 1;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */