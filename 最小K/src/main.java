import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[] input={4,5,1,6,2,3,7,8};
        ArrayList<Integer> res=GetLeastNumbers_Solution(input,4);
        System.out.println(1);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return new ArrayList<Integer>();
        }
        Arrays.sort(input);
        Integer[] res= new Integer[k];
        for(int i=0;i<k;i++){
            res[i]=input[i];
        }
        List tmpRes=Arrays.asList(res);
        return new ArrayList<Integer>(tmpRes);
    }
}
