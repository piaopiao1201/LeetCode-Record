import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        List<String> operator =new ArrayList<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        for(int i=0;i<tokens.length;i++){
            if(operator.indexOf(tokens[i])==-1){
                stack.add(Integer.valueOf(tokens[i]));
            }else{
                Integer i2=stack.pop();
                Integer i1=stack.pop();
                if(tokens[i].equals("+")){
                    stack.add(i1+i2);
                }
                if(tokens[i].equals("-")){
                    stack.add(i1-i2);
                }
                if(tokens[i].equals("*")){
                    stack.add(i1*i2);
                }
                if(tokens[i].equals("/")){
                    stack.add(i1/i2);
                }
            }
        }
        return stack.peek();
    }
}
