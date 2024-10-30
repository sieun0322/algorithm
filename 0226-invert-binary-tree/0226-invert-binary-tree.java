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
        Stack<TreeNode> stk= new Stack<>();
        
        if(root==null) {
          return root;
        }
        stk.push(root);
        while(stk.size()>0){
            TreeNode r = stk.pop();
            if(r.left !=null)  stk.push(r.left);
            if(r.right !=null)  stk.push(r.right);
            TreeNode temp = r.left;
            r.left = r.right;
            r.right = temp;
        }
        return root;
    }
}