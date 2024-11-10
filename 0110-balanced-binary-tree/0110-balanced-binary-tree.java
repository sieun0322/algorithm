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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(!isBalanced(root.left) || !isBalanced(root.right)) return false;
        int height = height(root.left) - height(root.right);
        if(height>1||height<-1) return false;
        return true;
    }
    public int height(TreeNode root) {
        if(root == null) return 1;
        int maxHeight = height(root.left)>height(root.right)?height(root.left):height(root.right);
        return maxHeight+1;
    }
}