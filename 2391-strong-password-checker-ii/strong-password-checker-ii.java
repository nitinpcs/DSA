class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;

        for(int i=0; i<password.length()-1; i++) if(password.charAt(i) == password.charAt(i+1)) return false;

        int uc = 0, lc = 0, d = 0;
        for(char c : password.toCharArray()) {
            if(c >= '0' && c <= '9') d++;
            else if(c >= 'A' && c <= 'Z') uc++;
            else if(c >= 'a' && c <= 'z') lc++;
        }
        int sp = password.length() - d - uc - lc;
        return d > 0 && uc > 0 && lc > 0 && sp > 0;
    }
}