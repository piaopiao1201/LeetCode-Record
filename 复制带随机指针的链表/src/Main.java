import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        Node res=new Node();
        Node temp=res;
        Node tempHead=head;
        Map<Node,Node> map=new HashMap<>();
        while(tempHead!=null){
            Node tmp=new Node();
            map.put(tempHead,tmp);
            tmp.val=tempHead.val;
            temp.next=tmp;
            temp=temp.next;
            tempHead=tempHead.next;
        }
        Node temp2=res.next;
        while(head!=null){
            temp2.random=map.get(head.random);
            temp2=temp2.next;
            head=head.next;
        }
        return res.next;
    }
}
