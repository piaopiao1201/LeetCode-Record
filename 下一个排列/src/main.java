public class main {
    public static void main(String[] args) {
        int[] nums={3,2,1};
        nextPermutation(nums);
        System.out.println(1);
    }
    public static void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int index1=-1;
        int value1=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                value1=nums[i];
                index1=i;
                break;
            }
        }
        if(index1==-1){
            int remainLength=nums.length;
            for(int j=0;j<remainLength/2;j++){
                int temp=nums[nums.length-1-j];
                nums[nums.length-1-j]=nums[j+index1+1];
                nums[j+index1+1]=temp;
            }
            return;
        }
        for(int i=index1+1;i<nums.length;i++){
            if(i==nums.length-1||(nums[i]>=nums[index1]&&nums[i+1]<=nums[index1])){
                int temp=nums[i];
                nums[i]=nums[index1];
                nums[index1]=temp;
                break;
            }
        }
        int remainLength=nums.length-index1-1;

        for(int j=0;j<remainLength/2;j++){
            int temp=nums[nums.length-1-j];
            nums[nums.length-1-j]=nums[j+index1+1];
            nums[j+index1+1]=temp;
        }
    }
}
