import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        try{
            int i=1,j=0;
            int p=i/j;
            System.out.println(1);
        }catch (Exception e){
            System.out.println(2);
        }
    }
    public void wiggleSort(int[] nums) {
        int[] arr= Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);

        //int length=(arr.length%2==0)?arr.length/2:arr.length/2+1;
        int startLength=(arr.length%2==0)?arr.length/2-1:arr.length/2;
        int length=arr.length/2;
        int nowLength=0;
        for(int i=startLength;i>=0;i--){
            nums[nowLength++]=arr[i];
            if(nowLength>=arr.length){
                break;
            }
            nums[nowLength++]=arr[i+length];
        }
    }
}
