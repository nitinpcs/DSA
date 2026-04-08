class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=str.length-1; i>=0; i--) {
            str[i].trim();
            sb.append(str[i]).append(" ");
        }
        return sb.toString().trim();
    }
}