class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') st.push(sb.length());
            else if(ch == ')') {
                int start = st.pop();
                reverse(sb, start, sb.length()-1);
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    void reverse(StringBuilder sb, int i, int j) {
        while(i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, temp);
        }
    }
}