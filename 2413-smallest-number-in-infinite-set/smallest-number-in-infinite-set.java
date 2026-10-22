class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int count ;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        count = 1;
    }
    
    public int popSmallest() {
        if(pq.isEmpty() || pq.peek() > count) {
            return count++;
        }
        if(pq.peek() == count) count++;
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(!pq.contains(num)) pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */