import sun.reflect.generics.tree.Tree;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Integer[] arr={1,2,5,6,2,3,4};
        List tmp=Arrays.asList(arr);
        List<Integer> num=new ArrayList<Integer>(tmp);
        num.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        System.out.println(1);
    }
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> num=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();

        TreeNode tmp=root;
        while (tmp!=null||!stack.isEmpty()){
            if(tmp!=null){
                num.add(tmp.val);
                stack.add(tmp);
                tmp=tmp.left;
            }else{
                tmp=stack.pop();
                tmp=tmp.right;
            }
        }
        num.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        return num.get(k-1);
    }
}
