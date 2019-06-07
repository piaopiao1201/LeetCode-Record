import java.util.ArrayList;
import java.util.List;

public class main {
    private static List<Integer> tree1;
    private static List<Integer> tree2;
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(8);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        System.out.println(HasSubtree(t1,t2));
    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        tree1=new ArrayList<Integer>();
        tree2=new ArrayList<Integer>();
        inOrder(root1,tree1);
        inOrder(root2,tree2);
        for(int i=0;i<tree1.size()-tree2.size()+1;i++){
            int j;
            for(j=0;j<tree2.size();j++){
                if(tree2.get(j)!=tree1.get(i+j)){
                    break;
                }
            }
            if(j==tree2.size()){
                return true;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root,List<Integer> t1){
        if(root==null){
            return;
        }
        inOrder(root.left,t1);
        t1.add(root.val);
        inOrder(root.right,t1);
    }
}
