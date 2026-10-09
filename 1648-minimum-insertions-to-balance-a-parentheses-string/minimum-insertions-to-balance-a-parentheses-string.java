class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int open = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                i++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) open--;
                    else res++;
                    i += 2;
                } else {
                    if (open > 0) {
                        open--;
                        res++;
                    } else res += 2;
                    i++;
                }
            }
        }
        res += open * 2;
        return res;
    }
}
