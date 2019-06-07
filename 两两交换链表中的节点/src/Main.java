public class Main {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        //ListNode head4=new ListNode(4);
        head.next=head2;
        head2.next=head3;
        //head3.next=head4;
        ListNode res=swapPairs(head);
        System.out.println(1);
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(1);
        ListNode temp = newHead;
        while (true) {
            if (head == null) {
                temp.next=null;
                break;
            }
            ListNode next = head.next;
            if(next==null){
                temp.next=head;
                break;
            }
            ListNode tempNext = next.next;
            next.next = head;
            temp.next = next;
            temp = head;
            head = tempNext;
        }
        return newHead.next;
    }
}
