class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        boolean[] have = new boolean[1000];

        int n = digits.length;

        for(int i = 0; i < n; i++) {
            if(digits[i] == 0) continue;

            for(int j = 0; j < n; j++) {
                if(i == j) continue; 

                for(int k = 0; k < n; k++) {
                    if(k == i || k == j || digits[k] % 2 == 1) continue;

                    int num = digits[i]*100 + digits[j]*10 + digits[k];

                    if(have[num]) continue;
                    have[num] = true;
                    count++;
                }
            }
        }
        return count;
    }
}