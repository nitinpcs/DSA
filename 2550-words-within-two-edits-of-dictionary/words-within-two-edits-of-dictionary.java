class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans = new ArrayList<>();
        for(String s : queries) {
            if(check(s, dictionary)) ans.add(s);
        }
        return ans;
    }

    boolean check(String s, String[] dic) {

        for(String d : dic) {
            int edit = 0;
            for(int i=0; i<s.length(); i++) if(s.charAt(i) != d.charAt(i)) edit++;
            if(edit <= 2) return true;
        }
        return false;
    }
}