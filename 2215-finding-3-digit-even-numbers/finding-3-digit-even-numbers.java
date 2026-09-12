class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;

        boolean[] have = new boolean[1000];
        List<Integer> nums = new ArrayList<>();
        

        for(int i = 0; i < n; i++) {
            if(digits[i] == 0) continue;

            for(int j = 0; j < n; j++) {
                if(i == j) continue; 

                for(int k = 0; k < n; k++) {
                    if(k == i || k == j || digits[k] % 2 == 1) continue;

                    int num = digits[i]*100 + digits[j]*10 + digits[k];

                    if(have[num]) continue;
                    have[num] = true;
                    nums.add(num);
                }
            }
        }
        int[] res = new int[nums.size()];
        int i = 0;
        for(int ele : nums) res[i++] = ele;
        Arrays.sort(res);
        return res; 
    }
}