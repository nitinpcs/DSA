class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        boolean turn = true;
        while(i < n && j < m) {
            if(turn) sb.append(word1.charAt(i++));
            else sb.append(word2.charAt(j++));
            turn = !turn;
        }
        while(i < n) sb.append(word1.charAt(i++));
        while(j < m) sb.append(word2.charAt(j++));
        return sb.toString();
    }
}