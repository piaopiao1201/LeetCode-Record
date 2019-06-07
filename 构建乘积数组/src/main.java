import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        int[] B=multiply(A);
        System.out.println(1);
    }
    public static int[] multiply(int[] A) {
        int[] b=new int[A.length];
        List<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
            arr.add(A[i]);
        }
        for(int i=0;i<b.length;i++){
            List temp= Arrays.asList(A);
            int tmpRes=1;
            List<Integer> list=new ArrayList<Integer>();
            list.addAll(arr);
            list.remove(i);
            for(Integer j:list){
                tmpRes*=j;
            }
            b[i]=tmpRes;
        }
        return b;
    }
}

