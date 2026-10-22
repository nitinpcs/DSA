class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i : nums1) {
            map1.put(i, 1);
        }
        for(int i : nums2) {
            map2.put(i, 1);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i : map1.keySet()) {
            if(!map2.containsKey(i)) temp.add(i);
        }
        res.add(new ArrayList<>(temp));
        temp.clear();
        for(int i : map2.keySet()) {
            if(!map1.containsKey(i)) temp.add(i);
        }
        res.add(new ArrayList<>(temp));

        return res;
    }
}