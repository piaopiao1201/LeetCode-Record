public class Main {
    public static void main(String[] args) {

    }
    public static int isPresent(Node root, int val){
    /* For your reference
    class Node {
            Node left, right;
            int data;
                    Node(int newData) {
                left = right = null;
                data = newData;
            }
        }
    */
        if(root==null){
            return 0;
        }
        if(root.data==val){
            return 1;
        }else if(root.data<val){
            return isPresent(root.right,val);
        }else{
            return isPresent(root.left,val);
        }
    }
}
