class Robot {
    int w, h;
    int x = 0, y = 0;
    int dir = 1; 
    int perimeter;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.perimeter = 2 * (w + h) - 4;
    }
    
    public void step(int num) {
        if (perimeter == 0) return;

        num %= perimeter;

        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 2; 
            }
            return;
        }

        while (num-- > 0) {
            if (dir == 1) { 
                if (x + 1 < w) x++;
                else {
                    dir = 0;
                    y++;
                }
            } 
            else if (dir == 0) { 
                if (y + 1 < h) y++;
                else {
                    dir = 3;
                    x--;
                }
            } 
            else if (dir == 3) { 
                if (x - 1 >= 0) x--;
                else {
                    dir = 2;
                    y--;
                }
            } 
            else {
                if (y - 1 >= 0) y--;
                else {
                    dir = 1;
                    x++;
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        if (dir == 0) return "North";
        if (dir == 1) return "East";
        if (dir == 2) return "South";
        return "West";
    }
}