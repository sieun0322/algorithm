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
        List<ListNode> visited = new ArrayList<ListNode>();
        
        ListNode result = head;
        while(result != null){
            visited.add(result);
            result = result.next;
            if(visited.contains(result)){
                return result;
            }
        }
        return null;
    }
}