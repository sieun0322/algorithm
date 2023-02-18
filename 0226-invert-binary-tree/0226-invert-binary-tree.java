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
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            invert(root);
        }
        return root;
    }
    public static void invert(TreeNode r){
        TreeNode temp = r.left;
        r.left = r.right;
        r.right = temp;
        if(r.left != null){
            invert(r.left);
        }
        if(r.right != null){
            invert(r.right);
        }
    }
}