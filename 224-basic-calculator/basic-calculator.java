class Solution {
    public int calculate(String s) {
        int n = s.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int res = 0;
        int curr = 0;
        int sign = 1;

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) curr = curr*10 + (ch-'0');
            else if(ch == '+' || ch == '-') {
                res += curr * sign;
                curr = 0;
                sign = ch == '+' ? 1 : -1;
            }
            else if(ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                curr = 0;
                sign = 1;
            }
            else if(ch == ')') {
                res += curr*sign;
                res *= st.pop();
                res += st.pop();
                curr = 0;
            }
        }
        res += sign * curr;
        return res;
    }
}