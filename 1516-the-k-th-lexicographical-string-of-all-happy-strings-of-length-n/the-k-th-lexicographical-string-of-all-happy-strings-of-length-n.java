class Solution {
    int count = 0;
    String ans ;
    public String getHappyString(int n, int k) {
        ans = "";
        happyString(n, new StringBuilder(), k);
        return ans;
    }

    void happyString(int n, StringBuilder sb, int k){
        if(n==0){
            count++;
            if(count == k){
                ans = sb.toString();
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(n < 0) return;

        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'a') {
            happyString(n-1, sb.append('a'), k);
        }
        if(!ans.equals("")) return;
        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'b') {
            happyString(n-1, sb.append('b'), k);
        }
        if(!ans.equals("")) return;
        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'c') {
            happyString(n-1, sb.append('c'), k);
        }
        if(!ans.equals("")) return;
        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
    }
}