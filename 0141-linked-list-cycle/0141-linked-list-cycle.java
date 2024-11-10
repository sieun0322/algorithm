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
    public boolean hasCycle(ListNode head) {
        List<ListNode> past = new ArrayList<>();
        while(head!=null){
            if(past.indexOf(head)!=-1){
                return true;
            }
            past.add(head);
            head = head.next;
        }
        return false;
    }
}