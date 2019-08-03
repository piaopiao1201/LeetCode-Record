import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s="3[a2[c]]";
        String res=decodeString(s);
        System.out.println(res);
    }
    public static String decodeString(String s) {
        Stack<Integer> intStack=new Stack<>();
        Stack<String> strStack=new Stack<>();
        int start=0;
        int num=0;
        String res="";
        while(start<s.length()){
            if(s.charAt(start)>='0'&&s.charAt(start)<='9'){
                while(true){
                    if(s.charAt(start)>='0'&&s.charAt(start)<='9'){
                        num=num*10+s.charAt(start++)-'0';
                    }else{
                        start--;
                        break;
                    }
                }
            }else if((s.charAt(start)>='a'&&s.charAt(start)<='z')||(s.charAt(start)>='A'&&s.charAt(start)<='Z')){
                res+=s.charAt(start);
            }else if(s.charAt(start)=='['){
                strStack.add(res);
                intStack.add(num);
                res="";
                num=0;
            }else if(s.charAt(start)==']'){
                int tmp=intStack.pop();
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<tmp;i++){
                    sb.append(res);
                }
                String temp=strStack.pop();
                temp+=sb.toString();
                strStack.add(temp);
                res=strStack.pop();
            }
            start++;
        }
        return res;
    }
}
