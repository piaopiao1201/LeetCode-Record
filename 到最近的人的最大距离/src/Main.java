import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] seats={0,1};
        int res=maxDistToClosest(seats);
        System.out.println(1);
    }
    public static int maxDistToClosest(int[] seats) {
        int[] leftMin=new int[seats.length];
        int[] rightMin=new int[seats.length];
        List<Integer> zeroIndex=new ArrayList<Integer>();
        int nearOne=-seats.length;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
                zeroIndex.add(i);
                leftMin[i]=i-nearOne;
            }else{
                nearOne=i;
            }
        }
        nearOne=Integer.MAX_VALUE;
        for(int i=seats.length-1;i>=0;i--){
            if(seats[i]==0){
                rightMin[i]=nearOne-i;
            }else{
                nearOne=i;
            }
        }
        int maxRes=Integer.MIN_VALUE;
        for(int i=0;i<zeroIndex.size();i++){
            maxRes=Math.max(maxRes,Math.min(leftMin[zeroIndex.get(i)],rightMin[zeroIndex.get(i)]));
        }
        return maxRes;
    }
}
