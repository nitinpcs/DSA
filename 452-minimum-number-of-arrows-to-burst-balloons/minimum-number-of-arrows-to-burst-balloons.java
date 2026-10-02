class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Comparator<int[]> byEnd = Comparator.comparingInt(s -> s[1]);
        Arrays.sort(points, byEnd);
        int res = 1;
        int Pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > Pos) {
                res++;
                Pos = points[i][1];
            }
        }
        return res;
    }
}