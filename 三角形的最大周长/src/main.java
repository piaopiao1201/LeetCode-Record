import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        int[] A={1,2,1};
        int res=largestPerimeter(A);
        System.out.println(1);
    }
    public static int largestPerimeter(int[] A) {
        Integer[] tempA=new Integer[A.length];
        int start=0;
        for(int i:A){
            tempA[start++]=i;
        }
        if(tempA.length<3){
            return 0;
        }
        Arrays.sort(tempA, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2)){
                    return 0;
                }
                return o1<o2?1:-1;
            }
        });
        int s1=0,s2=1,s3=2;
        for(int i=0;i<tempA.length-2;i++){
            for(int j=i+1;j<tempA.length-1;j++){
                for(int k=j+1;k<tempA.length;k++){
                    if(tempA[k]+tempA[j]>tempA[i]){
                        return tempA[i]+tempA[j]+tempA[k];
                    }else{
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
