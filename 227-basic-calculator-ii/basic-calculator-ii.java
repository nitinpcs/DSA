class Solution {
    public int calculate(String s) {
        int len = s.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int curNumber = 0;
        char operation = '+'; 

        for(int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                curNumber = curNumber*10 + (cur - '0');
            }
            if(!Character.isDigit(cur) && !Character.isWhitespace(cur) || i == len - 1) {
                if(operation == '+') st.push(curNumber);
                else if(operation == '-') st.push(-curNumber);
                else if(operation == '*') st.push(st.pop() * curNumber);
                else st.push(st.pop() / curNumber);

                curNumber = 0;
                operation = cur;
            }
        }
        
        int result = 0;
        while(!st.isEmpty()) result += st.pop();

        return result;
    }
}