public class Main {
    public static void main(String[] args) {

    }
    public int[] constructArray(int n, int k) {
        int[] res=new int[n];
        if(n==2){
            res[0]=1;
            res[1]=2;
            return res;
        }
        res[0]=1;
        res[1]=k+1;
        int even=2;
        int odd=k;
        for(int i=2;i<=k;i++){
            if(i%2==0){
                res[i]=even++;
            }else{
                res[i]=odd--;
            }
        }
        for(int i=k+1;i<n;i++){
            res[i]=i+1;
        }
        return res;
    }
}
