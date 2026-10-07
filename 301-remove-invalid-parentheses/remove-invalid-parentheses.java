class Solution {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int inValid = 0;
        int b = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') b++;
            else if(ch == ')') b--;
            if(b < 0) {
                inValid++;
                b = 0;
            }
        }
        inValid += b;
        List<String> res = new ArrayList<>();
        generate(s, new StringBuilder(), 0, inValid, res, 0);
        return res;
    }

    void generate(String s, StringBuilder sb, int idx, int skip, List<String> res, int bal) {
        if(bal < 0) return;
        if(idx >= s.length()) {
            if(bal == 0) {
                if(!set.contains(sb.toString())) {
                    res.add(sb.toString());
                    set.add(sb.toString());
                }
                
            }
            return;
        }

        int b = 0;
        if(s.charAt(idx) == '(') b++;
        else if(s.charAt(idx) == ')') b--;
        if(skip > 0) {
            generate(s, sb, idx+1, skip-1, res, bal);
        }
        sb.append(s.charAt(idx));
        generate(s, sb, idx+1, skip, res, bal+b);
        sb.deleteCharAt(sb.length()-1);
    }
}