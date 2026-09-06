class Solution {
    public long countVowels(String word) {
        int n = word.length();
        String vow = "aeiou";
        long ans = 0;

        for(int i=0; i<n; i++) {
            if(vow.indexOf(word.charAt(i)) != -1) {
                ans += (long)(i+1)*(n-i);
            }
        }

        return ans;
    }
}