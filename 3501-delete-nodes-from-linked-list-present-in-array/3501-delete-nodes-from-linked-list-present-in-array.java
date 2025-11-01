/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> valuesToRemove = new HashSet<>();
      
        for (int value : nums) {
            valuesToRemove.add(value);
        }
        ListNode result = new ListNode(0, head);
        for (ListNode preNode = result; preNode.next != null;) {
            if (valuesToRemove.contains(preNode.next.val)) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }
        return result.next;
    }
}