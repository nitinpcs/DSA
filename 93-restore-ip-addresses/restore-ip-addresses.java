class Solution {
    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        helper(s, 0, 0, new StringBuilder());
        return res;
    }

    void helper(String s, int idx, int count, StringBuilder sb) {
        if (idx == s.length() && count == 4) {
            res.add(sb.toString());
            return;
        }

        if (count == 4 || idx == s.length()) return;

        int len = sb.length();

        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            String curr = s.substring(idx, i + 1);

            if (curr.length() > 1 && curr.charAt(0) == '0') break;

            int val = Integer.parseInt(curr);
            if (val > 255) break;

            if (count > 0) sb.append('.');
            sb.append(curr);

            helper(s, i + 1, count + 1, sb);
            sb.setLength(len);
        }
    }
}