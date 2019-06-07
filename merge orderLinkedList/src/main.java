import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list=new ArrayList<Integer>();
        ListNode ret=new ListNode(0);
        ListNode retTmp=ret;
        for(int i=0;i<lists.length;i++){
            ListNode tmp=lists[i];
            while(tmp!=null){
                list.add(tmp.val);
                tmp=tmp.next;
            }
        }

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2<o1?-1:1;
//            }
//        });
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2<o1?-1:1;
            }
        });
        for(Integer i:list){
            retTmp.next=new ListNode(i);
            retTmp=retTmp.next;
        }
        return ret.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret=new ListNode(0);
        ListNode tmp=ret;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tmp.next=new ListNode(l1.val);
                tmp=tmp.next;
                l1=l1.next;
            }else{
                tmp.next=new ListNode(l2.val);
                tmp=tmp.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            tmp.next=new ListNode(l1.val);
            tmp=tmp.next;
            l1=l1.next;
        }

        while(l2!=null){
            tmp.next=new ListNode(l2.val);
            tmp=tmp.next;
            l2=l2.next;
        }

        return ret.next;
    }
}
