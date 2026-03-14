class Solution {

    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        dfs(n, k, new StringBuilder());
        return ans;
    }

    void dfs(int n, int k, StringBuilder sb) {

        if (sb.length() == n) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
            return;
        }

        for (char ch : new char[]{'a','b','c'}) {

            if (sb.length() > 0 && sb.charAt(sb.length()-1) == ch)
                continue;

            sb.append(ch);

            dfs(n, k, sb);

            if (!ans.equals("")) return; 

            sb.deleteCharAt(sb.length()-1);
        }
    }
}