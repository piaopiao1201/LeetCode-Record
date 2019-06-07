public class main {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        temp.next=new ListNode(2);
        temp=temp.next;
        temp.next=new ListNode(3);
        temp=temp.next;
        temp.next=new ListNode(4);
        temp=temp.next;
        temp.next=new ListNode(5);
        temp=temp.next;
        ListNode res=ReverseList(head);
        System.out.println(1);
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode Old=head;
        ListNode New=Old.next;
        while(New!=null){
            ListNode temp=New;
            New=New.next;
            Old.next=New;
            temp.next=head;
            head=temp;
        }
        return head;
    }
}
