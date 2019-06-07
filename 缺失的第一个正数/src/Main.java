public class Main {
    public static void main(String[] args) {
        int[] nums={1};
        int res=firstMissingPositive(nums);
        System.out.println(1);
    }
    public static int firstMissingPositive(int[] nums) {
        int length=nums.length;
        int[] tempArr=new int[length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=1&&nums[i]<=length){
                //int temp=nums[nums[i]];
                tempArr[nums[i]-1]=nums[i];
                //nums[i]=temp;
            }
        }
        boolean flag=false;
        for(int i=0;i<tempArr.length;i++){
            if(tempArr[i]!=i+1){
                return i+1;
            }else{
                flag=true;
            }
        }
        if(!flag){
            return 1;
        }
        return length+1;
    }
}
