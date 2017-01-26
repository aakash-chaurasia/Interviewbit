package LinkedLists.List2Pointers;

/**
 * Created by Aakash on 12/17/2016.
 */
public class RemoveNthNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        while(temp != null && n-- > 0) {
            temp = temp.next;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(temp != null) {
            prev = curr;
            curr = curr.next;
            temp = temp.next;
        }

        if(prev == null) {
            ListNode temp1 = head.next;
            head.next = null;
            head = temp1;
        } else {
            ListNode temp1 = curr.next;
            curr.next = null;
            prev.next = temp1;
        }
        return head;
    }
}