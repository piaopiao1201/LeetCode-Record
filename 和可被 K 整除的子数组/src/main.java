import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] a={4,5,0,-2,-3,1};
        int res=subarraysDivByK2(a,5);
        System.out.println(1);
    }
    public static int subarraysDivByK2(int[] A, int K) {
        int allSum=0;
        int firstSum=0;
        int[] res=new int[A.length];
        Arrays.fill(res,0);
        for(int i=1;i<=A.length;i++){
            //长度为i
            int sum=0;
            for(int j=0;j<A.length-i+1;j++){
                res[j]+=A[j+i-1];
                if(res[j]%K==0){
                    allSum++;
                }
//                if(j==0){
//                    firstSum=firstSum+A[j+i-1];
//                    sum=firstSum;
//                    if(sum%K==0){
//                        allSum++;
//                    }
//                }else{
//                    sum-=A[j-1];
//                    sum+=A[j+i-1];
//                    if(sum%K==0){
//                        allSum++;
//                    }
//                }
            }
        }
        return allSum;
    }
    public static int subarraysDivByK(int[] A, int K) {
        int[][] table=new int[A.length][K];
        table[0][A[0]%K]=1;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<K;j++){
                int k=j;
                while(k<A[i]){
                    k+=K;
                }

                table[i][j]=Math.max(table[i-1][j],table[i-1][j]+table[i-1][(k-A[i])%K]);
            }
        }
        return table[A.length-1][0];
    }
}
