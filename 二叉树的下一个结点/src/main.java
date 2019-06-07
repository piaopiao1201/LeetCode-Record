import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        TreeLinkNode l1=new TreeLinkNode(8);
        TreeLinkNode l2=new TreeLinkNode(6);
        TreeLinkNode l3=new TreeLinkNode(10);
        TreeLinkNode l4=new TreeLinkNode(5);
        TreeLinkNode l5=new TreeLinkNode(7);
        TreeLinkNode l6=new TreeLinkNode(9);
        TreeLinkNode l7=new TreeLinkNode(11);
        l1.left=l2;
        l1.right=l3;
        l2.left=l4;
        l2.right=l5;
        l3.left=l6;
        l3.right=l7;
        l2.next=l1;
        l3.next=l1;
        l4.next=l2;
        l5.next=l2;
        l6.next=l3;
        l7.next=l3;
        TreeLinkNode res=GetNext(l1);
        System.out.println(1);
    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode ques=pNode;
        while(pNode.next!=null){
            pNode=pNode.next;
        }
        Stack<TreeLinkNode> stack=new Stack<TreeLinkNode>();
        List<TreeLinkNode> list=new ArrayList<TreeLinkNode>();
        TreeLinkNode temp=pNode;
        while(temp!=null||!stack.empty()){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                list.add(temp);
                if(list.size()>1&&list.get(list.size()-2)==ques){
                    return temp;
                }
                temp=temp.right;
            }

        }
        return list.get(list.size()-1);
    }
}
