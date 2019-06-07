import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        int[] nums1=new int[1];
        int[] nums2=new int[1];
        FindNumsAppearOnce(array,nums1,nums2);
        System.out.println(1);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> res=new LinkedHashSet<Integer>();
        Set<Integer> visited=new HashSet<Integer>();
        for(int i=0;i<array.length;i++){
            Integer tmp=array[i];
            if(visited.contains(tmp)){
                res.remove(tmp);
            }else{
                res.add(tmp);
                visited.add(tmp);
            }
        }
        int time=0;
        for(Integer i:res){
            if(time==0){
                num1[0]=i;
                time++;
                continue;
            }
            if(time==1){
                num2[0]=i;
                time++;
            }
        }
    }
}
