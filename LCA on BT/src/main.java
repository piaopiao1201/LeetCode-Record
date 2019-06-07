import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class main {
    public static void main(String[] args) {

//        System.out.println(father.length);
//        father[4]=4;

        TreeNode r1=new TreeNode(-1);
        TreeNode r2=new TreeNode(0);
        TreeNode r3=new TreeNode(3);
        TreeNode r4=new TreeNode(-2);
        TreeNode r5=new TreeNode(4);
        TreeNode r6=new TreeNode(8);
        r1.left=r2;
        r1.right=r3;
        r2.left=r4;
        r2.right=r5;
        r4.left=r6;
        TreeNode res=lowestCommonAncestor(r1,r3,r5);
        System.out.println(1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //使用并查集获得节点的父节点位置信息
        //遍历并查集获取目标节点路径
        //问题转化为链表相同节点问题
        int arrLength=20000;
        int[] father=new int[arrLength];
        List<TreeNode> p1=new ArrayList<TreeNode>();
        List<TreeNode> q1=new ArrayList<TreeNode>();
        TreeNode[] fatherT=new TreeNode[arrLength];
        int origin=arrLength/2;
        Arrays.fill(father,-1);
        Arrays.fill(fatherT,null);
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode tmp=root;
        while(tmp!=null||!stack.isEmpty()){
            if(tmp!=null){
                stack.add(tmp);
                if(tmp.left!=null){
                    father[origin+tmp.left.val]=origin+tmp.val;
                    fatherT[origin+tmp.left.val]=tmp;
                    tmp=tmp.left;
                }else{
                    tmp=null;
                }
            }else{
                tmp=stack.pop();
                if(tmp.right!=null){
                    father[origin+tmp.right.val]=origin+tmp.val;
                    fatherT[origin+tmp.right.val]=tmp;
                    tmp=tmp.right;
                }else{
                    tmp=null;
                }
            }
        }

        TreeNode find=p;
        while(father[origin+find.val]!=-1){
            p1.add(find);
            find=fatherT[origin+find.val];
        }
        p1.add(find);

        TreeNode find2=q;
        while(father[origin+find2.val]!=-1){
            q1.add(find2);
            find2=fatherT[origin+find2.val];
        }
        q1.add(find2);
        if(p1.size()>q1.size()){
            int length=p1.size()-q1.size();
            p1=p1.subList(length,p1.size());
        }
        if(p1.size()<q1.size()){
            int length=q1.size()-p1.size();
            q1=q1.subList(length,q1.size());
        }

        for(int i=0;i<p1.size();i++){
            if(p1.get(i).val==q1.get(i).val){
                return p1.get(i);
            }
        }
        return null;
    }
}
