class Solution {
    List<String> list;
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        happyString(n, new StringBuilder());
        Collections.sort(list);
        return list.size() >= k ? list.get(k-1) : "";
    }

    void happyString(int n, StringBuilder sb){
        if(n==0){
            list.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(n < 0) return;

        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'a') {
            happyString(n-1, sb.append('a'));
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'b') {
            happyString(n-1, sb.append('b'));
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1) != 'c') {
            happyString(n-1, sb.append('c'));
        }

        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
    }
}