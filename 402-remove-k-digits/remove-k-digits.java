class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(char ch : num.toCharArray()) {
            while(!st.isEmpty() && k > 0 && ch < st.peek()) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-- > 0) st.pop();
        StringBuilder sb = new StringBuilder();
        for(char ch : st) sb.append(ch);
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() > 0 ? sb.toString() : "0";
    }
}