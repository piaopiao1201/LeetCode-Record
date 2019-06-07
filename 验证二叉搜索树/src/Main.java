
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
//    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//    假设一个二叉搜索树具有如下特征：
//
//    节点的左子树只包含小于当前节点的数。
//    节点的右子树只包含大于当前节点的数。
//    所有左子树和右子树自身必须也是二叉搜索树。

    public static void main(String[] args) {
        TreeNode s1=new TreeNode(1);
        TreeNode s2=new TreeNode(2);
        TreeNode s3=new TreeNode(3);
        s2.left=s1;
        s2.right=s3;
        System.out.println(isValidBST(s2));
    }
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> arr=new ArrayList<Integer>();
        //stack.push(root.val);
        TreeNode temp=root;
        while(!stack.empty()||temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                TreeNode tmp=stack.pop();
                if(arr.size()>0){
                    if(tmp.val<arr.get(arr.size()-1)){
                        return false;
                    }
                }
                arr.add(tmp.val);
                temp=tmp.right;
            }
        }
        return true;
    }
}
