class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int count = 0, moves = 0;

        for(int i=0; i<n; i++) {
            res[i] = moves;
            if(boxes.charAt(i) == '1') count++;
            moves += count;
        }

        moves = 0;
        count = 0;

        for(int i=n-1; i>=0; i--) {
            res[i] += moves;
            if(boxes.charAt(i) == '1') count++;
            moves += count;
        }

        return res;
    }
}