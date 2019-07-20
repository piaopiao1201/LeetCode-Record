public class Main {
    public static void main(String[] args) {
        
    }
    public int countPrimes(int n) {
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrimes(i)){
                count++;
            }
        }
        return count;
    }
    public boolean isPrimes(int n){
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        int a=(int)(Math.sqrt(n)+1);
        for(int i=3;i<=a;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
