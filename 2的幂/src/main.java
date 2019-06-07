public class main {
    public static void main(String[] args) {

    }
    public static boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        String str=Integer.toBinaryString(n);
        int oneNum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                if(oneNum==1){
                    return false;
                }else{
                    oneNum++;
                }
            }
        }
        return true;
    }
}
