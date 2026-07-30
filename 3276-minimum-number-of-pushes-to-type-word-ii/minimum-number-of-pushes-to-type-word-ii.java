class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) freq[ch-'a']++;
        Arrays.sort(freq);

        int push = 0;
        reverse(freq);
        for(int i=0; i<26; i++) {
            if(freq[i] == 0) break;
            push += (i/8 +1)*freq[i];
        }
        return push;
    }

    void reverse(int[] x) {
        int i=0, j=25;
        while(i < j) {
            int temp = x[i];
            x[i++] = x[j];
            x[j--] = temp;
        }
    }
}