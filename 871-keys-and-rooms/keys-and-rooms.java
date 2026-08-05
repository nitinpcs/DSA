class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] open = new boolean[n];
        open[0] = true;
        dfs(rooms, open, 0);

        for(boolean isOpen : open) {
            if(!isOpen) return false;
        }
        return true;
    }

    void dfs(List<List<Integer>> rooms, boolean[] open, int room) {
        open[room] = true;
        for(int key : rooms.get(room)) {
            if(!open[key]) {
                dfs(rooms, open, key);
            }
        }
    }
}