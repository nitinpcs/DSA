class Solution {
    public String removeOuterParentheses(String s) {
        int bal = 0;
        int start = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bal++;
                if(start == -1) start = i;
            }
            else {
                if(bal > 0) bal--;
                if(bal == 0) {
                    sb.append(s.substring(start+1,i));
                    start = -1;
                }
            }
        }
        return sb.toString();
    }
}