class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) freq[ch-'a']++;
        Arrays.sort(freq);

        int counter = 1;
        int push = 0;
        int i=25;
        while(i >= 0) {
            int j=i;
            int temp = 0;
            while(j >= 0 && temp < 8) {
                if(freq[j] > 0) {
                    push += freq[j]*counter;
                    temp++;
                }
                j--;
            }
            i = j;
            counter++;
        }
        return push;
    }
}