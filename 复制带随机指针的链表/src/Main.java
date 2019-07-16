import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Node node1=new Node(1,null,null);
        Node node2=new Node(2,null,null);
        Node node3=new Node(3,null,null);
        Node node4=new Node(4,null,null);
        Node node5=new Node(5,null,null);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        Node res=copyRandomList2(node1);
        System.out.println(1);
    }
    //普通copy链表的方式
    public static Node copyRandomList2(Node node){
        if(node==null){
            return null;
        }
        Node temp=new Node(node.val,null,null);
        temp.next=copyRandomList2(node.next);
        return temp;
    }
    //复制带有随机指针的链表
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
