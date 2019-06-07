import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int[] arr={1,5,4,36,6,5,7,8};
        reOrderArray(arr);
        System.out.println(1);
    }
    public static void reOrderArray(int [] array) {
        List<Integer> odd=new ArrayList<Integer>();
        List<Integer> even=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even.add(array[i]);
            }else{
                odd.add(array[i]);
            }
        }
        odd.addAll(even);
        for(int i=0;i<odd.size();i++){
            array[i]=odd.get(i);
        }
    }
}
