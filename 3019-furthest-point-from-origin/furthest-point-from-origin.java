class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count_moves = 0;
        int blank = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if (move == 'L') {
                count_moves++;
            } else if (move == 'R') {
                count_moves--;
            } else {
                blank++;
            }
        }
        return Math.abs(count_moves) + blank;
    }
}