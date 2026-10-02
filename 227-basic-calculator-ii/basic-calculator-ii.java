class Solution {
    public int calculate(String s) {
        int n = s.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        char ops = '+';
        int num = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + (ch - '0');
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == n-1) {
                if(ops == '+') st.push(num);
                else if(ops == '-') st.push(-num);
                else if(ops == '*') st.push(st.pop() * num);
                else st.push(st.pop() / num);

                num = 0;
                ops = ch;
            }
        }
        int ans = 0;
        for(int i : st) ans += i;
        return ans ;
    }
}