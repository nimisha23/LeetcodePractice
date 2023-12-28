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
    //TC : O(N Log K) -> size of pq is k and we are building the pq N times
    //SC : O(K)
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists == null || lists.length == 0) return null;
    //     PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
    //     ListNode res = new ListNode();
    //     ListNode head = res;
    //     for(ListNode node : lists) {
    //         if(null != node)
    //             pq.add(node);
    //     }
    //     while(!pq.isEmpty()) {
    //         ListNode tmp = pq.poll();
    //         if(null != tmp.next)
    //             pq.add(tmp.next);
    //         res.next = tmp;
    //         res = res.next;
    //     }
    //     return head.next;
    // }

    //TC : O(N)
    //SC : O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode res = new ListNode();
        ListNode head = res;

        while(true) {
            int min = Integer.MAX_VALUE;
            int min_index = 0;
            boolean isBreak = true;
            for(int i = 0; i < lists.length; i++) {
                if(null != lists[i]) {
                    if(lists[i].val < min) {
                        min = lists[i].val;
                        min_index = i;
                    }
                    isBreak = false;
                }
            }
            if(isBreak) {
                break;
            }
            res.next = lists[min_index];
            lists[min_index] = lists[min_index].next;
            res = res.next;
        }
        return head.next;
    }
}