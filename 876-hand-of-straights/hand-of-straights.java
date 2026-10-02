class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);
        Arrays.sort(hand);

        for(int i = 0; i < n; i++) {
            if(map.containsKey(hand[i])) {
                int val = map.get(hand[i]);
                for(int j = hand[i] + 1; j < hand[i] + groupSize; j++) {
                    if(!map.containsKey(j)) return false;
                    int f = map.get(j);
                    if(f == 1) map.remove(j);
                    else map.put(j, f - 1);
                }
                if(val == 1) map.remove(hand[i]);
                else {
                    map.put(hand[i], val-1);
                    i--;
                }
            }
        }
        return true;
    }
}