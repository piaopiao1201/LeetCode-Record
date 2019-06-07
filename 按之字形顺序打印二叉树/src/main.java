import sun.reflect.generics.tree.Tree;

import java.util.*;

public class main {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        ArrayList<ArrayList<Integer>> res=Print2(t1);
        System.out.println(1);
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<Integer> layer=new LinkedList<Integer>();
        ArrayList<Integer> tmpRes=new ArrayList<Integer>();
        ArrayList<Integer> tmpLayer=new ArrayList<Integer>();
        queue.offer(pRoot);
        layer.offer(1);
        while(queue.peek()!=null){
            TreeNode temp=queue.poll();
            Integer tmpLyer=layer.poll();
            tmpLayer.add(tmpLyer);
            tmpRes.add(temp.val);
            if(temp.left!=null){
                queue.offer(temp.left);
                layer.offer(tmpLyer+1);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
                layer.offer(tmpLyer+1);
            }
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(tmpLayer.size()==0){
            return res;
        }
        int lastDig=tmpLayer.get(0);
        int i=0;
        boolean flag=true;
        while(i<tmpLayer.size()){
            int startI=i;
            while(i<tmpLayer.size()&&tmpLayer.get(i)==lastDig){
                i++;
            }
            if(i<tmpLayer.size()){
                lastDig=tmpLayer.get(i);
            }

            int tmpLength=i-startI;
            List<Integer> ttmp=tmpRes.subList(startI,startI+tmpLength);
            if(flag){
               flag=!flag;
            }else{
                Collections.reverse(ttmp);
                flag=!flag;
            }
            ArrayList<Integer> ttmpRes=new ArrayList<Integer>();
            ttmpRes.addAll(ttmp);
            res.add(ttmpRes);
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(null);
        queue.add(pRoot);
        ArrayList<Integer> list=new ArrayList<Integer>();
        boolean flag=true;
        while(queue.size()>1){
            TreeNode temp=queue.removeFirst();
            if(temp==null){
                Iterator<TreeNode> iter=null;
                if(flag){
                    iter=queue.iterator();
                    flag=!flag;
                }else{
                    iter=queue.descendingIterator();
                    flag=!flag;
                }
                while(iter.hasNext()){
                    TreeNode tempVal=(TreeNode)iter.next();
                    list.add(tempVal.val);
                }
                res.add(list);
                list.clear();
                queue.add(null);
                continue;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

        return res;
    }
}
