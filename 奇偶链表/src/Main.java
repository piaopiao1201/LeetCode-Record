public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode oddHead=head;
        ListNode oddTail=head;
        ListNode evenHead=head.next;
        ListNode evenTail=head.next;
        while(true){
            if(evenTail.next==null){
                break;
            }
            oddTail.next=evenTail.next;
            oddTail=oddTail.next;
            if(oddTail.next==null){
                break;
            }
            evenTail.next=oddTail.next;
            evenTail=evenTail.next;
        }
        oddTail.next=evenHead;
        evenTail.next=null;
        return oddHead;
    }
}
