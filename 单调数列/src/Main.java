public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public boolean isMonotonic(int[] A) {
        //检验递增
        int start=A[0];
        int i;
        for(i=1;i<A.length;i++){
            if(A[i]<start){
                break;
            }else{
                start=A[i];
            }
        }
        if(i==A.length){
            return true;
        }

        start=A[0];
        for(i=1;i<A.length;i++){
            if(A[i]>start){
                return false;
            }else{
                start=A[i];
            }
        }
        return true;
    }
}
