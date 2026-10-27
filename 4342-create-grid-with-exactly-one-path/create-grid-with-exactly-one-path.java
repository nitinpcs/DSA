class Solution {
    public String[] createGrid(int m, int n) {
        String[] str = new String[m];
        for(int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(i == 0 || j == n-1 ? '.' : '#');
            }
            str[i] = sb.toString();
        }
        return str;
    }
}