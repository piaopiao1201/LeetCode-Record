import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public Node connect(Node root) {
        Queue<Node> que=new LinkedList<Node>();
        Queue<Integer> queLayer=new LinkedList<Integer>();
        if(root==null){
            return root;
        }
        que.add(root);
        int startLayer=1;
        queLayer.add(startLayer);
        Node last=null;
        while(que.peek()!=null){
            Node temp=que.poll();
            int layer=queLayer.poll();
            if(layer==startLayer){
                if(last!=null){
                    last.next=temp;
                    last=temp;
                }
            }else{
                last=temp;
                startLayer=layer;
            }
            if(temp.left!=null){
                que.add(temp.left);
                queLayer.add(layer+1);
            }
            if(temp.right!=null){
                que.add(temp.right);
                queLayer.add(layer+1);
            }
        }
        return root;
    }
}
