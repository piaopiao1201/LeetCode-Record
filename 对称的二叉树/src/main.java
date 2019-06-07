import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(6);
        TreeNode t3=new TreeNode(6);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(7);
        TreeNode t6=new TreeNode(7);
        TreeNode t7=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        boolean res=isSymmetrical(t1);
        System.out.println(1);
    }
    public static boolean isSymmetrical(TreeNode pRoot)
    {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> list1=new ArrayList<Integer>();
        TreeNode temp=pRoot;
        while(temp!=null||!stack.empty()){
            if(temp!=null){
                list1.add(temp.val);
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                temp=temp.right;
            }
        }
        jingxiang(pRoot);
        List<Integer> list2=new ArrayList<Integer>();
        TreeNode temp2=pRoot;
        while(temp2!=null||!stack.empty()){
            if(temp2!=null){
                list2.add(temp2.val);
                stack.push(temp2);
                temp2=temp2.left;
            }else{
                temp2=stack.pop();
                temp2=temp2.right;
            }
        }
        return list1.equals(list2);
    }
    public static void jingxiang(TreeNode pRoot){
        if(pRoot==null){
            return;
        }
        jingxiang(pRoot.left);
        jingxiang(pRoot.right);
        TreeNode temp=pRoot.left;
        pRoot.left=pRoot.right;
        pRoot.right=temp;
    }
}
