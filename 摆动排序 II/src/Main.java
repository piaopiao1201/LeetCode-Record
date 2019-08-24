import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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
