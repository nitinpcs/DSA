class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int total = 0, curr = 0;
        for(int i=0; i<n; i++) {
            if(boxes.charAt(i) == '1') {
                total += i;
                curr++;
            }
        }

        int[] moves = new int[n];
        int prefix = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            int left = i*count - prefix;
            int temp = boxes.charAt(i)=='1' ? curr-count-1 : curr-count;
            int cur = boxes.charAt(i)=='1' ? total-prefix-i : total-prefix;
            int right = cur - i*temp;

            moves[i] = left + right;
            if(boxes.charAt(i) == '1') {
                prefix += i;
                count++;
            }
        }
        return moves;
    }
}