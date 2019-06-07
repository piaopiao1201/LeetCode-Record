import java.util.HashMap;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        System.out.println(isValid("[()]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        HashMap<Character,Character> hashMap=new HashMap<Character, Character>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        for(int i=0;i<s.length();i++){
            char tmp=s.charAt(i);
            if(tmp=='('||tmp=='['||tmp=='{'){
                stack.push(tmp);
            }else{
                //处理输入为[']']的情况
                if(stack.empty()){
                    return false;
                }
                if(stack.peek()==hashMap.get(tmp)){
                    stack.pop();
                }else{
                    //处理输入为['[(]']的情况
                    return false;
                }
            }
        }
        //处理输入为['[']的情况
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
