class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) freq[ch-'a']++;
        Integer[] idx = new Integer[26];
        for(int i=0; i<26; i++) idx[i] = i;
        Arrays.sort(idx, (a,b) -> freq[b] - freq[a]);

        int counter = 1;
        int push = 0;
        int i=0;
        while(i < 26) {
            int j=i;
            int temp = 0;
            while(j < 26 && temp < 8) {
                if(freq[idx[j]] > 0) {
                    push += freq[idx[j]]*counter;
                    temp++;
                }
                j++;
            }
            i = j;
            counter++;
        }
        return push;
    }
}