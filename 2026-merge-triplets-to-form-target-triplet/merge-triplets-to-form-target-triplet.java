class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int first = -1, second = -1, third = -1;
        for(int i = 0; i < n; i++) {
            int[] temp = triplets[i];
            if(temp[0] == target[0]) {
                if(temp[1] <= target[1] && temp[2] <= target[2]) first = i;
            }
            if(temp[1] == target[1]) {
                if(temp[0] <= target[0] && temp[2] <= target[2]) second = i;
            }
            if(temp[2] == target[2]) {
                if(temp[1] <= target[1] && temp[0] <= target[0]) third = i;
            }

            if(first != -1 && second != -1 && third != -1) return true;
        }
        return false;
    }
}