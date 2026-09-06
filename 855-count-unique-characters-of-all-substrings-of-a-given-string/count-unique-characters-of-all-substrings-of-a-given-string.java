class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prev = new int[n];
        int[] next = new int[n];

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            prev[i] = map.getOrDefault(ch, -1);
            map.put(ch, i);
        }
        map.clear();
        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);
            next[i] = map.getOrDefault(ch, n);
            map.put(ch, i);
        }

        int unique = 0;
        for(int i=0; i<n; i++) {
            unique += (i-prev[i])*(next[i]-i);
        }

        return unique;
    }
}