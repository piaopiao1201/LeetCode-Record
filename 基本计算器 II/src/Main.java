import java.util.*;

public class Main {
    public static void main(String[] args) {
        int res=calculate(" 3+5 / 2 ");
        System.out.println(res);
    }
    public static int calculate(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        List<String> backEnd=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        for(char c:s.toCharArray()){
            if(c==' '){
                if(sb.length()>0){
                    backEnd.add(sb.toString());
                    sb.setLength(0);
                }
                continue;
            }
            if(map.keySet().contains(c)){
                if(sb.length()>0){
                    backEnd.add(sb.toString());
                    sb.setLength(0);
                }
                while (!stack.empty()){
                    if(map.get(c)<=map.get(stack.peek())){
                        backEnd.add(String.valueOf(stack.pop()));
                    }else{
                        break;
                    }
                }
                stack.add(c);
            }else{
                sb.append(c);
            }
        }
        if(sb.length()>0){
            backEnd.add(sb.toString());
            sb.setLength(0);
        }
        while(!stack.isEmpty()){
            backEnd.add(String.valueOf(stack.pop()));
        }
        Stack<Integer> stack1=new Stack<>();
        for(int i=0;i<backEnd.size();i++){
            String value=backEnd.get(i);
            if(!value.equals("+")&&!value.equals("-")&&!value.equals("*")&&!value.equals("/")){
                stack1.add(Integer.valueOf(value));
            }else{
                int i1=stack1.pop();
                int i2=stack1.pop();
                if(value.equals("+")){
                    stack1.add(i1+i2);
                }else if(value.equals("-")){
                    stack1.add(i2-i1);
                }else if(value.equals("*")){
                    stack1.add(i1*i2);
                }else if(value.equals("/")){
                    stack1.add(i2/i1);
                }
            }
        }
        return stack1.pop();
    }
}
