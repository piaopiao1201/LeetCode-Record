import java.util.ArrayList;
import java.util.Comparator;

public class main {
    private static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(12);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        FindPath(t1,15);
        System.out.println(1);
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> tmpRes=new ArrayList<Integer>();
        tmpRes.add(root.val);
        find(root,tmpRes,target);
        res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>=o2.size()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        return res;
    }
    public static void find(TreeNode root,ArrayList<Integer> tmpRes,int target){
        if(root.left==null&&root.right==null){
            //tmpRes.add(root.val);
            int sum=0;
            for(Integer i:tmpRes){
                sum+=i;
            }
            if(sum==target){
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                tmp.addAll(tmpRes);
                res.add(tmp);
            }
            return;
        }

        if(root.left!=null){
            tmpRes.add(root.left.val);
            find(root.left,tmpRes,target);
            tmpRes.remove(tmpRes.size()-1);
        }
        if(root.right!=null){
            tmpRes.add(root.right.val);
            find(root.right,tmpRes,target);
            tmpRes.remove(tmpRes.size()-1);
        }
    }
}
