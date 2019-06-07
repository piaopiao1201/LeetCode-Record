import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] array={1,2,4,7,11,15};
        int sum=15;
        ArrayList<Integer> res=FindNumbersWithSum(array,sum);
        System.out.println(1);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        int minRes=Integer.MAX_VALUE;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    if(array[i]*array[j]<minRes){
                        minRes=array[i]*array[j];
                        res.clear();
                        res.add(array[i]);
                        res.add(array[j]);
                    }
                    break;
                }else if(array[i]+array[j]>sum){
                    break;
                }
            }
        }
        return res;
    }
}
