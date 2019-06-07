class Solution {
    public static void main(String[] args) {
        String res=addBinary("1010","1011");
        System.out.println(1);
    }
    public static String addBinary(String a, String b) {
        String temp="";
        if(a.length()<b.length()){
            temp=a;
            a=b;
            b=temp;
        }
        String res="";
        int i=0;
        int goTo=0;
        while(i<b.length()){
            int tempA=a.length()-1-i;
            int tempB=b.length()-1-i;
            int AInt=a.charAt(tempA)-'0';
            int BInt=b.charAt(tempB)-'0';
            if(AInt+BInt+goTo>=2){
                res=(AInt+BInt+goTo)%2+res;
                goTo=1;
            }else{
                res=(AInt+BInt+goTo)%2+res;
                goTo=0;
            }
            i++;
        }
        while(i<a.length()){
            int tempA=a.length()-1-i;
            int AInt=a.charAt(tempA)-'0';
            if(AInt+goTo>=2){
                res=(AInt+goTo)%2+res;
                goTo=1;
            }else{
                res=(AInt+goTo)%2+res;
                goTo=0;
            }
            i++;
        }
        while(goTo!=0){
            res=goTo%2+res;
            goTo=0;
        }
        return res;
    }
}