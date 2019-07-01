public class Main {
    public static void main(String[] args) {
        int[] A={16,69,88,85,79,87,37,33,39,34};
        int L=55,R=57;
        int res=numSubarrayBoundedMax(A,L,R);
        System.out.println(1);
    }
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count=0;
        int tempStart=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>=L&&A[i]<=R){
                count+=i-tempStart+1;
            }else{
                if(A[i]>R){
                    tempStart=i+1;
                }else{
                    int k;
                    for(k=i-1;k>=tempStart;k--){
                        if(A[k]>=L&&A[k]<=R){
                            break;
                        }
                    }
                    count+=k-tempStart+1;
                }
            }
        }
        return count;
    }
}
