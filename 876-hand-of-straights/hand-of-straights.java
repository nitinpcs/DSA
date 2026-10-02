class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);
        
        while(!map.isEmpty()) {
            int small = map.firstKey();
            for(int i = 0; i < groupSize; i++) {
                int curr = small + i;
                if(!map.containsKey(curr)) return false;
                int val = map.get(curr);
                if(val == 1) map.remove(curr);
                else map.put(curr, val - 1);
            }
        }
        return true;
    }
}