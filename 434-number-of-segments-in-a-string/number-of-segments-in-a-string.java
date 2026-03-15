class Solution {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        String[] str = s.split(" ");
        int count = 0;

        for(String cur : str) {
            if(cur.length() > 0) count++;
        }
        return count;
    }
}