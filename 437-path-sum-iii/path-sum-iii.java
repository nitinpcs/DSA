/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, 0);
    }

    int dfs(TreeNode root, int t, long sum) {
        if(root == null) return 0;
        int count = 0;
        sum += root.val;
        if(map.containsKey(sum - t)){
            count += map.get(sum-t);
        }
        map.put(sum, map.getOrDefault(sum, 0)+1);

        count += dfs(root.left, t, sum);
        count += dfs(root.right, t, sum);

        map.put(sum, map.get(sum)-1);
        if(map.get(sum) == 0) map.remove(sum);

        return count;
    }
}