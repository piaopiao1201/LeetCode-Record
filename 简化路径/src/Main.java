import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    public String simplifyPath(String path) {
        String[] strArr=path.split("/");
        List<String> stack=new ArrayList<String>();
        for(String s:strArr){
            if(s.length()==0||s.equals(".")){
                continue;
            }
            if(!s.equals("..")){
                stack.add(s);
            }else{
                if(stack.size()>0){
                    stack.remove(stack.size()-1);
                }
            }
        }
        if(stack.size()==0){
            return "/";
        }

        String res="";
        for(int i=0;i<stack.size();i++){
            res+=stack.get(i);
            res+='/';
        }

        res='/'+res.substring(0,res.length()-1);
        return res;
    }
}
