import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        List<String> res=generateParenthesis(6);
        System.out.println(1);
    }
        public static List<String> generateParenthesis(int n) {
            List<String> res=new ArrayList<String>();
            List<Character> quesArr=new ArrayList<Character>();
            boolean[] flag=new boolean[2*n];
            for(int i=0;i<n;i++){
                quesArr.add('(');
                quesArr.add(')');
            }
            String tempRes="";
            find(quesArr,flag,res,2*n,tempRes,0,0);
            return res;
        }
        public static void find(List<Character> quesArr,boolean[] flag,List<String> res,int size,String tempRes,int open,int close){
            if(close>open){
                return;
            }
            if(tempRes.length()==size){
                if(judgeVaild(tempRes)){
                    if(!res.contains(tempRes)){
                        res.add(tempRes);
                    }
                }
                return;
            }
            for(int i=0;i<quesArr.size();i++){
                if(!flag[i]){
                    flag[i]=true;
                    tempRes+=quesArr.get(i);
                    if(quesArr.get(i)=='('){
                        find(quesArr,flag,res,size,tempRes,open+1,close);
                    }else{
                        find(quesArr,flag,res,size,tempRes,open,close+1);
                    }
                    flag[i]=false;
                    tempRes=tempRes.substring(0,tempRes.length()-1);
                }
            }

        }
        //有效括号判断函数
        public static Boolean judgeVaild(String ques){
            Stack<Character> stack=new Stack<Character>();
            for(int i=0;i<ques.length();i++){
                Character c=ques.charAt(i);
                if(c=='('){
                    stack.push(c);
                }else if(c==')'){
                    if(stack.empty()){
                        return false;
                    }
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            if(!stack.empty()){
                return false;
            }
            return true;
        }
}
