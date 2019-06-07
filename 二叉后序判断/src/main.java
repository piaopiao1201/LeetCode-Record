public class main {
    public static void main(String[] args) {
        int[] arr={4,6,8};
        boolean res=VerifySquenceOfBST(arr);
        System.out.println(1);
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {

        return isTrue(sequence,0,sequence.length-1);
    }
    public static boolean isTrue(int [] sequence,int start,int end){
        if(end-start<=1){
            return true;
        }
        int root=sequence[end];
        int begin=start;
        for(;begin<end;begin++){
            if(sequence[begin]>root){
                break;
            }
        }
        for(int j=begin;j<end;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        return isTrue(sequence,start,begin-1)&&isTrue(sequence,begin,end-1);
    }
}
