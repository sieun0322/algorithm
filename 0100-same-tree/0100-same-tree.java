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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return compare(p,q);
    }
    public boolean compare(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
            if(p.val == q.val){
                if(compare(p.left,q.left)&compare(p.right,q.right)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else if(p==null && q==null){
            return true;
        }else{
            return false;
        }
    }
}