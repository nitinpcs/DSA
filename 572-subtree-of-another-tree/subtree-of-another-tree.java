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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return root == subRoot;
        }
        if(root.val == subRoot.val && isValid(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean isValid(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return root == subRoot;
        }
        boolean left = isValid(root.left, subRoot.left);
        boolean right = isValid(root.right, subRoot.right);
        return left && right && (root.val == subRoot.val);
    }
}