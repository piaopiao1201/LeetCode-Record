import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] A={1,2,3,4};
        List<Integer> res=addToArrayForm(A,9999);
        System.out.println(1);
    }
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res=new ArrayList<Integer>();
        String[] B=String.valueOf(K).split("");
        int[] Bint=new int[B.length];
        for(int i=0;i<B.length;i++){
            Bint[i]=Integer.valueOf(B[i]);
        }
        int index=0;
        int jinwei=0;
        while(A.length-1-index>=0&&Bint.length-1-index>=0){
            int tempSum=A[A.length-1-index]+Bint[Bint.length-1-index]+jinwei;
            res.add(tempSum%10);
            jinwei=tempSum/10;
            index++;
        }
        while (A.length-1-index>=0){
            int tempSum=A[A.length-1-index]+jinwei;
            res.add(tempSum%10);
            jinwei=tempSum/10;
            index++;
        }
        while (Bint.length-1-index>=0){
            int tempSum=Bint[Bint.length-1-index]+jinwei;
            res.add(tempSum%10);
            jinwei=tempSum/10;
            index++;
        }
        if(jinwei!=0){
            res.add(jinwei);
        }
        Collections.reverse(res);
        return res;
    }
}
