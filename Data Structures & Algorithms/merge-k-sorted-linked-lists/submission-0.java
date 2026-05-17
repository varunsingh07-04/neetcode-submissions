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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode list;
        if(n>0) list = lists[0];
        else return null;
        for(int i=1;i<n;i++){
            list = mergeTwoLists(list,lists[i]);
        }
        return list; 
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode temp = list;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if (list1!=null) temp.next=list1;
        if (list2!=null) temp.next=list2;
        return list.next;

    }
}