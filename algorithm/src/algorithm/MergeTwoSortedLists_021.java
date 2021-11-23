package algorithm;

import java.util.Stack;

import model.ListNode;

/**
 * 
 * @author zion 
 * Runtime: 1 ms, faster than 26.99% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 39.4 MB, less than 27.11% of Java online submissions for Merge Two Sorted Lists.
 *
 */
public class MergeTwoSortedLists_021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1534236469; // output: bab
		//ListNode temp;
		ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
		ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
		
		//ListNode l1 = new ListNode();
		//ListNode l2 = new ListNode();
		ListNode result_1 = mergeTwoLists(l1,l2);
		
		while(result_1 != null) {
			System.out.println(result_1.val+" ");
			result_1 = result_1.next;
        }
	}

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	ListNode temp = new ListNode();
        ListNode result = temp;
        
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        
        while(l1 != null && l2 != null) {
                int v1 = l1.val;
                int v2 = l2.val;
                
	        	temp.next = new ListNode();
	        	temp = temp.next;
		        if(v1<=v2) {
		        	temp.val =v1;
		        	l1=l1.next;
		        }else {
		        	temp.val =v2;
		        	l2=l2.next;
		        }
        }
        while(l1 != null) {
        	temp.next = new ListNode();
        	temp = temp.next;
           	temp.val =l1.val;
        	l1=l1.next;
        }
        while(l2 != null) {
        	temp.next = new ListNode();
        	temp = temp.next;
        	temp.val =l2.val;
        	l2=l2.next;
        }
        return result.next;
    }

}
