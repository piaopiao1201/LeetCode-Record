public class Main {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }
    public static int divide(int dividend, int divisor) {
        if(dividend==0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative=(dividend^divisor)<0;
        long t=Math.abs((long)dividend);
        long p=Math.abs((long)divisor);
        int result=0;
        for(int i=31;i>=0;i--){
            if((t>>i)>=p){
                result+=1<<i;
                t-=p*(1<<i);
                System.out.println(t);
            }
        }

        return 1;
    }
}
