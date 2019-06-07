import java.util.Stack;

public class main {
    private static Stack<Integer> stack=new Stack<Integer>();

    public static void main(String[] args) {
        int[] pushA={1};
        int[] popA={1};
        boolean res=IsPopOrder(pushA,popA);
        System.out.println(1);
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int AIndex=0;
        //boolean res=true;
        for(int i=0;i<popA.length;i++){
            if(stack.empty()||stack.peek()!=popA[i]){
                if(AIndex>=pushA.length){
                    return false;
                }
                while(AIndex<pushA.length){
                    if(pushA[AIndex]!=popA[i]){
                        stack.push(pushA[AIndex]);
                        AIndex++;
                    }else{
                        stack.push(pushA[AIndex]);
                        AIndex++;
                        break;
                    }
                }
            }
            if(stack.peek()==popA[i]){
                stack.pop();
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
