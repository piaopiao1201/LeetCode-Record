import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);

    }
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res=new ArrayList<List<String>>();
        int m=getHeight(root);
        int n=(int)Math.pow(2,m)-1;
        for(int i=0;i<m;i++){
            List<String> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add("");
            }
            res.add(temp);
        }
        print(root,0,res,0,n-1);
        return res;
    }
    public void print(TreeNode root,int line,List<List<String>> res,int start,int end){
        if(root==null||start>end){
            return;
        }
        int insert=(start+end)/2;
        res.get(line).set(insert,root.val+"");
        print(root.left,line+1,res,start,insert-1);
        print(root.right,line+1,res,insert+1,end);
    }
    public static int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
