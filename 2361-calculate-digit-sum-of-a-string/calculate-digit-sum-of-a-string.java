class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i += k) {
                int total = 0;
                for(int j = i; j < Math.min(s.length(), i + k); j++) {
                    total += s.charAt(j) - '0';
                }
                sb.append(total);
            }
            s = sb.toString();
        }
        return s;
    }
}