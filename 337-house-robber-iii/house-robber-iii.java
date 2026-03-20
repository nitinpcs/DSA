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
    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(memo.containsKey(root)) return memo.get(root);

        int pick = root.val;
        if(root.left != null){
            pick += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            pick += rob(root.right.left) + rob(root.right.right);
        }

        int notPick = rob(root.left) + rob(root.right);

        int res = Math.max(pick, notPick);
        memo.put(root, res);

        return res;
    }
}