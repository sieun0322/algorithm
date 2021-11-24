package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import model.ListNode;
import model.TreeNode;

/**
 * 
 * @author zion 
 * Runtime: 1 ms, faster than 26.99% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 39.4 MB, less than 27.11% of Java online submissions for Merge Two Sorted Lists.
 *
 */
public class BinaryTreeInorderTraversal_094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1534236469; // output: bab
		//ListNode temp;
		TreeNode tn = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));

		List<Integer> result_1 = inorderTraversal(tn);
		
		for(Integer i : result_1) {
			System.out.println(i);
        }
	}

    public static List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
    	Queue<TreeNode> list = new LinkedList<TreeNode>();
    	TreeNode temp = root;
    	while(temp!= null) {
	    	while(temp.left!= null) {
	    		list.add(temp);//중위
	    		temp = temp.left;
	    	}
	    	result.add(temp.val);
	    	if(temp.right== null) {
	    		if(list.isEmpty()) {return result;}
	    		temp = list.poll();//중위
	    		result.add(temp.val);
	    	}
	    	temp=temp.right;

    	}
        return result;
    }

}
