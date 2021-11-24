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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 38.5 MB, less than 26.78% of Java online submissions for Binary Tree Inorder Traversal.
 *
 */
public class BinaryTreeInorderTraversal_094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ListNode temp;
		TreeNode tn = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

		List<Integer> result_1 = inorderTraversal(tn);

		for (Integer i : result_1) {
			System.out.println(i);
		}
	}

	static List<Integer> result = new LinkedList<Integer>();

	public static List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<Integer>();
        if(root != null) {
		    traversal(root);
        }
		return result;
	}

	public static void traversal(TreeNode root) {

		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		if (root.left != null) {
			traversal(root.left);
		}
		result.add(root.val);
		if (root.right != null) {
			traversal(root.right);
		}

		return;
	}

}
