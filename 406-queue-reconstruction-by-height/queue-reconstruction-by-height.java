class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Comparator<int[]> byHeight = (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);

            return Integer.compare(b[0], a[0]);
        };
        Arrays.sort(people, byHeight);
        List<int[]> l = new ArrayList<>();
        for(int[] p : people) {
            l.add(p[1], p);
        }
        
        return l.toArray(new int[people.length][]);
    }
}