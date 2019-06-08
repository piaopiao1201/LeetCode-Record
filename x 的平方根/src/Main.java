public class Main {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        int x=122;
        int mid=50000;
        System.out.println(mid*mid);
    }
    public static int mySqrt(int x) {
        int left=1,right=Math.min(x,46340);
        int available=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid*mid>x){
                right=mid-1;
            }else{
                available=mid;
                left=mid+1;
            }
        }
        return available;
    }
}
