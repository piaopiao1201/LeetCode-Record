import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        Queue<Integer> queLayer=new LinkedList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        que.add(root);
        int startLayer=1;
        queLayer.add(startLayer);
        List<Integer> list=new ArrayList<Integer>();
        while(que.peek()!=null){
            TreeNode temp=que.poll();
            int layer=queLayer.poll();
            if(layer==startLayer){
                list.add(temp.val);
            }else{
                if(startLayer%2==0){
                    Collections.reverse(list);
                }
                List<Integer> tempList=new ArrayList<Integer>(list);
                res.add(tempList);
                list.clear();
                list.add(temp.val);
                startLayer=layer;
            }
            if(temp.left!=null){
                que.add(temp.left);
                queLayer.add(layer+1);
            }
            if(temp.right!=null){
                que.add(temp.right);
                queLayer.add(layer+1);
            }
        }
        if(startLayer%2==0){
            Collections.reverse(list);
        }
        List<Integer> tempList=new ArrayList<Integer>(list);
        res.add(tempList);
        return res;
    }
}
