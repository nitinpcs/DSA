class Solution {
    public int sumOfPrimesInRange(int n) {
        int r = 0;
        int temp = n;
        while(temp > 0) {
            r = r*10 + temp%10;
            temp /= 10;
        }
        int size = Math.max(n, r);
        boolean[] prime = new boolean[size+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i=2; i*i <= size; i++) {
            if(prime[i]) {
                for(int j=2*i; j<=size; j+=i) prime[j] = false;
            } 
        }
        int sum = 0;
        for(int i=Math.min(n, r); i<=size; i++) if(prime[i]) sum += i;

        return sum;
    }
}