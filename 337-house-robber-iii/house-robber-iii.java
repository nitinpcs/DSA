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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rob = root.val + left[1] + right[1];
        int skip = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        return new int[]{rob, skip};
    }
}