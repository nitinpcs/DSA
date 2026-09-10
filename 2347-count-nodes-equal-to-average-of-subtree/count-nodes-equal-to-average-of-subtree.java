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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        countNodes(root);
        return ans;
    }

    public int[] countNodes(TreeNode root) {
        if(root.left == null && root.right == null) {
            ans++;
            return new int[]{root.val, 1};
        }

        int[] left = new int[2];
        int[] right = new int[2];
        if(root.left != null) left = countNodes(root.left);
        if(root.right != null) right = countNodes(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        if(sum / count == root.val) ans++;

        return new int[]{sum, count};

    } 
}