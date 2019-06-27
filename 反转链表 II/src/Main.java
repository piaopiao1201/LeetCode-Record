import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ListNode list1=new ListNode(1);
//        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(3);
//        ListNode list4=new ListNode(4);
        ListNode list5=new ListNode(5);
//        list1.next=list2;
//        list2.next=list3;
//        list3.next=list4;
//        list4.next=list5;
        list3.next=list5;
        ListNode res=reverseBetween(list3,1,2);
        System.out.println(1);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode temp=new ListNode(1);
        temp.next=head;
        head=temp;
        for(int i=1;i<m;i++){
            temp=temp.next;
        }
        int times=n-m;
        ListNode old=temp.next;
        ListNode now=old.next;
        ListNode next=now.next;
        int start=0;
        while(start++<times){
            now.next=old;
            if(start==times){
                break;
            }
            old=now;
            now=next;
            if(next!=null){
                next=next.next;
            }
        }
        temp.next.next=next;
        temp.next=now;
        return head.next;
    }
}
