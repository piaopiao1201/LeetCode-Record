import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(1);
        ListNode head3=new ListNode(4);
        head3.next=head;
        head.next=head1;
        head1.next=head2;
        ListNode res=sortList(head3);
        System.out.println(1);
    }
//    public static ListNode sortList(ListNode head) {
//        if(head==null){
//            return null;
//        }
//        //冒泡排序
//        ListNode headNode=head;
//        ListNode maoFirst=head.next;
//        for(ListNode i=headNode;i.next!=null;i=i.next){
//            for(ListNode j=head;j.next!=null;j=j.next){
//                if(j.val>j.next.val){
//                    int tmp=j.val;
//                    j.val=j.next.val;
//                    j.next.val=tmp;
//                }
//            }
//        }
//        return head;
//    }

    public static ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2){
                    return 0;
                }
                if(o1<o2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        ListNode res=new ListNode(2);
        ListNode temp=res;
        for(Integer i:list){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        return res.next;
    }
}
