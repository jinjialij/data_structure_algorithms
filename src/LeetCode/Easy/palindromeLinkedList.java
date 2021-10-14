package LeetCode.Easy;

public class palindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String []args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean result = palindromeLinkedList(head);
        System.out.println("head 1: "+result);
        head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        result = palindromeLinkedList(head);
        System.out.println("head 2: "+result);

        //1->2->3->4->3->2->1
        //1234321
        head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        result = palindromeLinkedList(head);
        System.out.println("head 3: "+result);

    }

    public static boolean palindromeLinkedList(ListNode head) {
        //reverse the linkedlist and see if it equals to the original one
        //O(n)
        if(head==null || head.next==null) return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(slow.val!=fast.val)return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        //reverse
        ListNode pre=null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }

}

