import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] A={0,1,-1};
        int[] B={-1,1,0};
        int[] C={0,0,1};
        int[] D={-1,1,1};
        int count=fourSumCount(A,B,C,D);
        System.out.println(1);
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int count=0;
        for(int i=0;i<A.length;i++){
            int sum1=0-A[i];
            for(int j=0;j<B.length;j++){
                int sum2=sum1-B[j];
                int min=0,max=D.length-1;
                while(min<C.length&&max>=0){
                    if(C[min]+D[max]==sum2){
                        int tempMin=min;
                        int leftCount=0;
                        while(tempMin<C.length){
                            if(C[tempMin]==C[min]){
                                leftCount++;
                                tempMin++;
                            }else{
                                break;
                            }
                        }
                        int tempMax=max;
                        int rightCount=0;
                        while(tempMax>=0){
                            if(D[tempMax]==D[max]){
                                rightCount++;
                                tempMax--;
                            }else{
                                break;
                            }
                        }
                        count+=leftCount*rightCount;
                        min=tempMin;
                        max=tempMax;
                    }else if(C[min]+D[max]<sum2){
                        min++;
                    }else{
                        max--;
                    }
                }
            }
        }
        return count;
    }
    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int temp=C[i]+D[j];
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int temp=A[i]+B[j];
                if(map.containsKey(-temp)){
                    count+=map.get(-temp);
                }
            }
        }
        return count;
    }
}
