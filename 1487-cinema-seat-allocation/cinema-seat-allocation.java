class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> map = new HashMap<>();
        for(int[] seat : reservedSeats) {
            if(seat[1] >= 2 && seat[1] <= 9) {
                int curr = map.containsKey(seat[0]) ? map.get(seat[0]) : 0;
                int value = curr | (1 << (seat[1]-2));
                map.put(seat[0], value);
            }
        }
        int ans = 2*(n - map.size());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int mask = entry.getValue();
            if((mask | left) == left || (mask | middle) == middle || (mask | right) == right) {
                ans++;
            }
        }
        return ans;
    }
}