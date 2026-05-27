class Solution {
    public int numberOfSpecialChars(String word) {
        int[][] lower = new int[26][2];
        int[][] upper = new int[26][2];

        for(int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if(!Character.isLowerCase(ch)) {
                int idx = ch - 'A';
                upper[idx][0] = 1;
                upper[idx][1] = i;
            }
        }
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)) {
                int idx = ch - 'a';
                lower[idx][0] = 1;
                lower[idx][1] = i;
            }
        }
        
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(lower[i][0] == 1 && upper[i][0] == 1 && lower[i][1] < upper[i][1]) {
                count++;
            }
        }
        return count;
    }
}