class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        int freq = nums.length / 3;
        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > freq) {
                l.add(entry.getKey());
            }
        }
        return l;
    }
}