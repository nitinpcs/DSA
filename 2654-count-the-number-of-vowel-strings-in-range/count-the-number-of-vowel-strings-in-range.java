class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        for(int i = left; i <= right; i++){
            String s = words[i];
            if(set.contains(s.charAt(0)) && set.contains(s.charAt(s.length()-1))) {
                count++;
            }
        }
        return count;
    }
}