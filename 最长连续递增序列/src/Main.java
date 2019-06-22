public class Main {
    public static void main(String[] args) {

    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start=nums[0];
        int maxLength=0;
        int tempLength=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>start){
                start=nums[i];
                tempLength++;
            }else{
                maxLength=Math.max(tempLength,maxLength);
                start=nums[i];
                tempLength=1;
            }
        }
        maxLength=Math.max(tempLength,maxLength);
        return maxLength;
    }
}
