import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Solution {
    int[] origin;
    public Solution(int[] nums) {
        origin= Arrays.copyOf(nums,nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(origin,origin.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp=Arrays.copyOf(origin,origin.length);
        Integer[] temp2=new Integer[temp.length];
        int p=0;
        for(Integer i:temp){
            temp2[p++]=i;
        }
        Arrays.sort(temp2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Random random=new Random();
                int i=random.nextInt(2);
                //int i=(int)Math.floor(Math.random()*2);
                if(i==0){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        p=0;
        for(int i:temp2){
            temp[p++]=i;
        }
        return temp;
    }
}
