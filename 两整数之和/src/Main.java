public class Main {
    public static void main(String[] args) {

    }
    public int getSum(int a, int b) {
        int sum=a^b;
        int carry=(a&b)<<1;
        if(carry!=0){
            return getSum(sum,carry);
        }
        return sum;
    }
}
