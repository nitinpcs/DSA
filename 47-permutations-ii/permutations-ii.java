class Solution {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void helper(int[] arr, int idx, List<List<Integer>> res, List<Integer> curr){
        if(idx == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        Set<Integer> used = new HashSet<>();

        for(int i = idx; i < arr.length; i++){
            if(used.contains(arr[i])) continue;

            used.add(arr[i]);

            swap(arr, i, idx);
            curr.add(arr[idx]);

            helper(arr, idx + 1, res, curr);

            curr.remove(curr.size() - 1);
            swap(arr, i, idx);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }
}