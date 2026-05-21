class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefix = new HashSet<>();
        for(int num : arr1) {
            while(num > 0) {
                prefix.add(num);
                num /= 10;
            }
        }

        int ans = 0;
        for(int num : arr2) {
            int len = getLength(num);
            while(num > 0) {
                if(prefix.contains(num)) {
                    ans = Math.max(ans, len);
                    break;
                }
                num /= 10;
                len--;
            }
        }

        return ans;
    }

    int getLength(int x) {
        int len = 0;
        while(x > 0) {
            x /= 10;
            len++;
        }

        return len;
    }
}