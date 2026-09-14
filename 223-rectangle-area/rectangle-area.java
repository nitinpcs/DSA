class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);

        if(by1 >= ay2 || ay1 >= by2 || bx1 >= ax2 || ax1 >= bx2) return a + b;
        
        int l = 0;
        if(bx1 <= ax2 && bx1 >= ax1) l = Math.min(ax2, bx2) - bx1;
        else if(ax1 >= bx1 && ax1 <= bx2) l = Math.min(bx2, ax2) - ax1;

        int h = 0;
        if(by1 <= ay2 && by1 >= ay1) h = Math.min(ay2, by2) - by1;
        else if(ay1 >= by1 && ay1 <= by2) h = Math.min(by2, ay2) - ay1;

        return a + b - (l * h);
    }
}