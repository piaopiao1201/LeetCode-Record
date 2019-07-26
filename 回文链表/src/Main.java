import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode i1=new ListNode(-129);
        ListNode i2=new ListNode(-129);
        i1.next=i2;
        isPalindrome(i1);
    }
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        List<Integer> tmp=new ArrayList<>(list);
        Collections.reverse(list);
        for(int i=0;i<list.size();i++){
            if(!list.get(i).equals(tmp.get(i))){
                return false;
            }
        }
        return true;
    }
}
