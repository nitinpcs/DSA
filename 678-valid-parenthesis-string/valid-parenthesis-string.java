class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open.push(i);
            else if(ch == '*') star.push(i);

            else {
                if(!open.isEmpty()) open.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }
        
        while(!open.isEmpty() && !star.isEmpty()) {
            if(open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }
            else return false;
        }
        return open.isEmpty();
    }
}