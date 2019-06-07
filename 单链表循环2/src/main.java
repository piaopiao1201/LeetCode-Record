import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> container=new HashSet<ListNode>();
        if(head==null){
            return null;
        }else{
            container.add(head);
        }

        ListNode node=head;
        while((node=node.next)!=null){
            if(container.contains(node)){
                return node;
            }else{
                container.add(node);
            }
        }
        return null;
    }
}
