import sun.reflect.generics.tree.Tree;

import java.util.*;

public class main {
    //private static List<Integer> Orders;
    //private static int Sum=Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        maxPathSum(root);
        System.out.println(1);
        Map<Integer,Integer> timeMap=new HashMap<Integer, Integer>();
        Set<Map.Entry<Integer, Integer>> collect=timeMap.entrySet();
        for(Map.Entry<Integer, Integer> entry:collect){
            return entry.getKey()
        }
    }
//    public int maxPathSum(TreeNode root) {
//        getOrder(root);
//        int[] dp=new int[Orders.size()];
//        dp[0]=Orders.get(0);
//        for(int i=1;i<Orders.size();i++){
//            dp[i]=Math.max(dp[i-1]+Orders.get(i),Orders.get(i));
//        }
//
//        int max=Integer.MIN_VALUE;
//        for (int i=0;i<dp.length;i++){
//            max=Math.max(max,dp[i]);
//        }
//        return max;
//    }

    public static int maxPathSum(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(Integer.MIN_VALUE);
        maxSum(root,res);
        return res.get(0);
    }

    public static int maxSum(TreeNode root,List<Integer> res){
        if(root==null){
            return 0;
        }
        int left=maxSum(root.left,res);
        int right=maxSum(root.right,res);
        res.set(0,Math.max(left+right+root.val,res.get(0)));
        return Math.max(Math.max(left,right)+root.val,0);
    }

}
