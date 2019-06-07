import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t3.left=t5;
        //String res=Serialize(t1);
        String ques="1,2,3,#,4,#,5";
        TreeNode root=Deserialize(ques);
        System.out.println(1);
    }

    public static TreeNode Deserialize(String str) {
        if(str.length()==0){
            return null;
        }
        String[] ques=str.split(",");
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        int i=0;
        TreeNode root=new TreeNode(Integer.parseInt(ques[i++]));
        TreeNode temp=root;
        queue.add(temp);
        while(queue.size()>0){
            TreeNode tmpVal=queue.removeFirst();
            if(i<ques.length){
                if(ques[i].equals("#")){
                    tmpVal.left=null;
                    i++;
                }else{
                    tmpVal.left=new TreeNode(Integer.parseInt(ques[i++]));
                    queue.add(tmpVal.left);
                }

            }
            if(i<ques.length){
                if(ques[i].equals("#")){
                    tmpVal.right=null;
                    i++;
                }else{
                    tmpVal.right=new TreeNode(Integer.parseInt(ques[i++]));
                    queue.add(tmpVal.right);
                }
            }
        }
        return root;
    }
}
