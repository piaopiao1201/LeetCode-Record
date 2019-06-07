public class main {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode tmp=head;
        ListNode tmp2=head.next;
        while(tmp2.next!=null){
            tmp.next=tmp2.next;
            tmp2.next=head;
            head=tmp2;
            tmp2=tmp.next;
        }
        tmp.next=null;
        tmp2.next=head;
        head=tmp2;
        return head;
    }
}
