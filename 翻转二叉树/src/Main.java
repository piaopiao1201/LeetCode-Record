public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        // transfer(root);
        // return root;
        TreeNode tmp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=tmp;
        return root;
    }
    public void transfer(TreeNode root){
        if(root==null){
            return;
        }
        transfer(root.left);
        transfer(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}
