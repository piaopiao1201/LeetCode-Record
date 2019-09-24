import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        double t=-3.75;
        int a=(int)t;
        double b=t-a;
        Calendar cal = Calendar.getInstance();
        double cd=(double) 4/3;
        double serverOffset = (double) cal.get(Calendar.ZONE_OFFSET) / 1000 / 60 / 60;
        System.out.println(1);
        String res=ScheduleUtils2.optionsToCron(1.5,"Point_4","18","23");
        Map<String,String> mapres=ScheduleUtils2.cronToOptions(1.5,res);
        System.out.println(1);
    }
    public boolean isSymmetric(TreeNode root) {
        List<Integer> listA=new ArrayList<Integer>();
        List<Integer> listB=new ArrayList<Integer>();
        generateList(listA,root);
        generateList2(listB,root);
        int i=0;
        if(listA.size()!=listB.size()){
            return false;
        }
        while(i<listA.size()){
            if(listA.get(i)==listB.get(i)){
                i++;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    public void generateList(List<Integer> listA, TreeNode root){
        if(root==null){
            listA.add(-1);
            return;
        }
        listA.add(root.val);
        generateList(listA,root.left);
        generateList(listA,root.right);
    }
    public void generateList2(List<Integer> listB,TreeNode root){
        if(root==null){
            listB.add(-1);
            return;
        }
        listB.add(root.val);
        generateList2(listB,root.right);
        generateList2(listB,root.left);
    }

    public boolean isSymmetric2(TreeNode root){
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return (t1.val==t2.val)&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
}
