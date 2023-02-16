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
    public int maxDepth(TreeNode root) {
        return root != null ? maxDepth(root,1): 0;
    }
    public static int maxDepth(TreeNode r, int cnt){
        int max = cnt;
        
        if(r.left != null || r.right != null ){
            if(r.left != null){
                int temp = maxDepth(r.left,cnt+1);
                max = max>temp?max:temp;
            }
            if(r.right != null){
                int temp = maxDepth(r.right,cnt+1);
                max = max>temp?max:temp;
            }
        }
        return max;
    }
}