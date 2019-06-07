import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println(hasCycle(null));
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        //使用快慢指针
        ListNode fastNode=head;
        ListNode node=head;
        while((node=node.next)!=null){
            if(fastNode==null||fastNode.next==null){
                return false;
            }
            fastNode=fastNode.next.next;
            if(fastNode==node){
                return true;
            }
        }
        return false;
    }
}
