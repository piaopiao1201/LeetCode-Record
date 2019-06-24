import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map=new HashMap<Integer,int[]>();
        int maxLength=0;
        int minDuLength=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                if(maxLength<1){
                    maxLength=1;
                    minDuLength=1;
                    int[] temp={1,i};
                    map.put(nums[i],temp);
                }else{
                    int[] temp={1,i};
                    map.put(nums[i],temp);
                }
            }else{
                int[] temp=map.get(nums[i]);
                if(temp[0]+1<maxLength){
                    temp[0]++;
                    map.put(nums[i],temp);
                }else if(temp[0]+1>maxLength){
                    maxLength=(++temp[0]);
                    minDuLength=i-temp[1]+1;
                    map.put(nums[i],temp);
                }else{
                    minDuLength=Math.min(i-temp[1]+1,minDuLength);
                    ++temp[0];
                    map.put(nums[i],temp);
                }
            }
        }
        return minDuLength;
    }
}
