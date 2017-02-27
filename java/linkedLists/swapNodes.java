/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode result = head.next;
        ListNode fp = head.next;
        ListNode sp = head;
        ListNode pre = null;
        
        
        while(fp.next != null && fp.next.next != null){
	    sp.next = fp.next;
	    fp.next = sp;
	    if(pre != null){
		pre.next = fp;
	    }
	    pre = sp;
	    sp = sp.next;
	    fp = sp.next;
        }
        
        //Need to do one more final switch
        
        if(pre != null){
	    pre.next = fp;
        }
        sp.next = fp.next;
        fp.next = sp;
        return result;
        
        
    }
    
    public ListNode recurSwapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode result = swapPairs(head.next.next);
        
        ListNode temp = head.next;
        head.next = result;
        temp.next = head;
        return temp;
        
    }
}