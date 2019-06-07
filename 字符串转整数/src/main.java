public class main {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
        //System.out.println(Integer.parseInt("012"));
    }

    public static Integer myAtoi(String str) {
        long ans=0;
        boolean fu=false;
        int start=0;
        while(start<str.length()&&str.charAt(start)==' '){
            start++;
        }

        if(start<str.length()&&str.charAt(start)=='+'){
            start++;
        }else if(start<str.length()&&str.charAt(start)=='-'){
            fu=true;
            start++;
        }

        for(int i=start;i<str.length();i++){
            if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
                ans=ans*10+str.charAt(i)-'0';
                if(ans>Integer.MAX_VALUE){
                    ans=Long.MAX_VALUE;
                    break;
                }
            }else{
                break;
            }
        }

        if(fu){
            ans=-ans;
        }
        int ret=0;
        if(ans>Integer.MAX_VALUE){
            ret=Integer.MAX_VALUE;
        }else if(ans<Integer.MIN_VALUE){
            ret=Integer.MIN_VALUE;
        }else{
            ret=(int)ans;
        }
        return ret;
    }
}
