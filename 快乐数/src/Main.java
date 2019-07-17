public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public boolean isHappy(int n) {
        int res=n;
        int count=0;
        while(true){
            if(res==1){
                return true;
            }
            res=convert(res);
            count++;
            if(count>20){
                return false;
            }
        }
    }
    public int convert(int n){
        String tempN=String.valueOf(n);
        int res=0;
        for(int i=0;i<tempN.length();i++){
            int tmp=tempN.charAt(i)-'0';
            res+=tmp*tmp;
        }
        return res;
    }
}
