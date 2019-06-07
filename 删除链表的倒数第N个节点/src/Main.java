public class Main {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        temp.next=new ListNode(2);
        temp=temp.next;
        ListNode res=removeNthFromEnd(head,2);
        System.out.println(1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next==null&&n==1){
//            return null;
//        }
        int count=1;
        ListNode temp=head;
        while(count<n){
            temp=temp.next;
            count++;
        }
        ListNode temp2=head;
        ListNode lastTemp=null;
        while(temp.next!=null){
            temp=temp.next;
            lastTemp=temp2;
            temp2=temp2.next;
        }
        if(lastTemp==null){
            return head.next;
        }
        lastTemp.next=temp2.next;
        return head;
    }
}
