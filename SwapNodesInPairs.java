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
    //public ListNode swapPairs(ListNode head) {
        // ListNode tmp = head;
        // ListNode prev = null;            
        // while(tmp != null && tmp.next != null) {
        //     ListNode next = tmp.next.next;
        //     if(head == tmp) {
        //         head = tmp.next;
        //     }
        //     if(prev != null) {
        //         prev.next = tmp.next;
        //     }
        //     tmp.next.next = tmp;
        //     tmp.next = next;
        //     prev = tmp;
        //     tmp = tmp.next;
        // }
        //Same as above just easier to read due to first and second nodes
    //     ListNode first = head;
    //     ListNode prev = null;    
    //     while(first != null && first.next != null) {
    //         ListNode second = first.next;
    //         if(head == first) { //this will be done just once, in the beginning to adjust head ptr
    //             head = second;
    //         }
    //         if(prev != null) {
    //             prev.next = second; //this is needed to connect each swapped pairs
    //         }
    //         first.next = second.next;
    //         second.next = first;
    //         prev = first;
    //         first = first.next;
    //     }
    //     return head;
    // }
    // Recursive
    // ListNode prev;
    // public ListNode swapPairs(ListNode head) {
    //     if(head == null) return null;
    //     ListNode first = head;
    //     ListNode second = first.next;
    //     if(second != null) {
    //         head = second;
    //     }
    //     prev = null;
    //     while(first != null) {
    //         second = first.next;
    //         first = helper(first, second);
    //     }
    //     return head;
    // } 

    // public ListNode helper(ListNode first, ListNode second) {
    //     if(first != null && second != null) {
    //         if(prev != null) {
    //             prev.next = second; //this is needed to connect each swapped pairs
    //         }
    //         first.next = second.next;
    //         second.next = first;
    //         prev = first;
    //         first = first.next;
    //         return first;
    //     }
    //     return null;
    // }
    // Recursive
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    public ListNode helper(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        first.next = helper(second.next);
        second.next = first;
        return second;
    }

}