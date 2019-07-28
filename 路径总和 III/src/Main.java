import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public int pathSum(TreeNode root, int sum) {
        List<Integer> res=new ArrayList<>();
        List<Integer> sumRes=new ArrayList<>();
        sumRes.add(0);
        find(root,res,sum,sumRes);
        return sumRes.get(0);
    }
    public void find(TreeNode root,List<Integer> res,int goal,List<Integer> sumRes){
        if(root==null){
            return;
        }
        List<Integer> tempRes=new ArrayList<>(res);
        tempRes.add(0);
        ListIterator<Integer> iterator=tempRes.listIterator();
        while (iterator.hasNext()){
            int tmp=iterator.next();
            if(tmp+root.val==goal){
                sumRes.set(0,sumRes.get(0)+1);
            }
            iterator.set(tmp+root.val);
//            else if(tmp+root.val<goal){
//                iterator.set(tmp+root.val);
//            }else{
//                iterator.remove();
//            }
        }
        find(root.left,tempRes,goal,sumRes);
        find(root.right,tempRes,goal,sumRes);
    }
}
