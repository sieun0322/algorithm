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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode result = new ListNode(0,temp);
        int x = 0;
        while(l1 !=null || l2!=null){
            temp.next= new ListNode();
            temp = temp.next;
            int sum = x;
            if(l1 !=null) {sum+=l1.val; l1 = l1.next!= null ? l1.next: null;}
            if(l2 !=null) {sum+=l2.val; l2 = l2.next!= null ? l2.next: null;}
            temp.val = sum%10;
            x=sum/10;
        }
        if(x!=0) temp.next= new ListNode(x);
        return result.next.next;
    }
}