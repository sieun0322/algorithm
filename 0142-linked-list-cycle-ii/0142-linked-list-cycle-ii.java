/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> visited = new LinkedList<ListNode>();
        
        ListNode result = head;
        while(result != null){
            visited.add(result);
            result = result.next;
            for(ListNode node: visited){
                if(node == result) return node;
            }
        }
        return null;
    }
}