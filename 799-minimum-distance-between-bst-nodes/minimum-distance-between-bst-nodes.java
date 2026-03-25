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
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        inOrder(root);
        return min;
    }

    void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(pre != null){
            min = Math.min(min, root.val-pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
}