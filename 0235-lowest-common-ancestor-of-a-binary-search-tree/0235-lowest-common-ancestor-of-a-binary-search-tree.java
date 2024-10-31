/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pNodes = findNodes(root, p.val);
        List<TreeNode> qNodes = findNodes(root, q.val);
        int size = pNodes.size()<qNodes.size()?pNodes.size():qNodes.size();
        
        for(int i=size-1; i>=0; i--){
            if(pNodes.get(i).val==qNodes.get(i).val){
                return pNodes.get(i);
            }
        }
        return root;
    }
    public List<TreeNode> findNodes(TreeNode root, int val) {
        List<TreeNode> parents = new ArrayList<>();
        TreeNode tmp = root;
        
        while(tmp.val!= val){
            parents.add(tmp);
            if(tmp.val<val){
                tmp = tmp.right;
            }else if(tmp.val>val){
                tmp = tmp.left;
            }
        }
        parents.add(tmp);
        return parents;
    }
}